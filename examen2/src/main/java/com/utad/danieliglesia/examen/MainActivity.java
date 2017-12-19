package com.utad.danieliglesia.examen;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.milib.LoginFragment;
import com.example.milib.LoginFragmentListener;
import com.example.milib.RegisterFragment;
import com.example.milib.RegisterFragmentListener;
import com.google.firebase.database.DataSnapshot;

public class MainActivity extends AppCompatActivity {
    LoginFragment loginFragment;
    RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asociamos el fragment del Login y del registro a variables
        loginFragment = (LoginFragment)getSupportFragmentManager().findFragmentById(R.id.fragmentLogin);
        registerFragment = (RegisterFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentRegister);

        MainActivityEvents mainActivityEvents = new MainActivityEvents(this);

        //Añadimos los seters a los fragmentos y al firebase
        loginFragment.setListener(mainActivityEvents);
        registerFragment.setListener(mainActivityEvents);
        DataHolder.instance.fireBaseAdmin.setListener(mainActivityEvents);

        //Creamos las transiciones para que aparezca primero el login
        FragmentTransaction transition = getSupportFragmentManager().beginTransaction();
        transition.show(loginFragment);
        transition.hide(registerFragment);
        transition.commit();
    }
}
//MainActivityEvents implementa los listeners de los fragmentos y metodos de firebase
class MainActivityEvents implements LoginFragmentListener, RegisterFragmentListener, FireBaseAdminListener{
    MainActivity mainActivity;

    public MainActivityEvents(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }
    //Cuando se ha pulsado el boton de login en la pantalla del login, llamara al metodo loginFragmentLoginButtonClicked que comprueba y loguea al usuario
    @Override
    public void loginFragmentLoginButtonClicked(String sUser, String sPass) {
        DataHolder.instance.fireBaseAdmin.loginConEmailYPassword(sUser,sPass,mainActivity);
    }
    //Cuando el boton Register de la pantalla de login sea pulsado llamara a este metodo que cambia de fragmento
    @Override
    public void loginFragmentRegisterButtonClicked() {
        FragmentTransaction transition = mainActivity.getSupportFragmentManager().beginTransaction();
        transition.hide(mainActivity.loginFragment);
        transition.show(mainActivity.registerFragment);
        transition.commit();
    }
    //Cuando el boton aceptar de la pantalla de registro se pulsa llama a este metodo que registra en la base de datos con email y contraseña
    @Override
    public void registerFragmentBtnAceptarClicked(String sUser, String sPass) {
        DataHolder.instance.fireBaseAdmin.registerConEmailYPassword(sUser,sPass,mainActivity);
    }
    //Cuando se pulsa el boton de cancelar en la pantalla del registro cambia de fragmento de vuelta al login
    @Override
    public void registerFragmentBtnCancelarClciked() {
        FragmentTransaction transition = mainActivity.getSupportFragmentManager().beginTransaction();
        transition.show(mainActivity.loginFragment);
        transition.hide(mainActivity.registerFragment);
        transition.commit();
    }
    //metodo que si el registro se hace correctamente pasa a la actividad 2
    @Override
    public void RegisterOk(Boolean ok) {
        if(ok){
            Intent intent = new Intent(mainActivity,Second.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        }
    }
    //metodo que si el login se hace correctamente pasa a la actividad 2
    @Override
    public void LoginOk(Boolean ok) {
        if(ok){
            Intent intent = new Intent(mainActivity,Second.class);
            mainActivity.startActivity(intent);
            mainActivity.finish();
        }
    }

    @Override
    public void Rama(String rama, DataSnapshot dataSnapshot) {

    }
}
