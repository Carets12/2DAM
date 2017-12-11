package es.vcarmen.socialtech;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.vcarmen.socialtech.Firebase.FireBaseRT;

/**
 * Created by Daniel Sierra Ráez
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, Serializable, GoogleApiClient.OnConnectionFailedListener {

    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.fab)FloatingActionButton fab;
    @BindView(R.id.fab1)FloatingActionButton fab1;
    @BindView(R.id.fab2)FloatingActionButton fab2;

    private ImageView photoImageView;
    private TextView nombreTextView, emailTextView;


    protected int contadorFab = 0;
    private GoogleApiClient googleApiClient;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener firebaAuthListener;

    FragmentManager fragmentManager = getSupportFragmentManager();
    public static FireBaseRT bd = new FireBaseRT();

    public static ArrayList<Contacto> listaContactos;
    public static ArrayList<Empresa> listaEmpesas;

    protected AdaptadorContacto adaptador;
    protected AdaptadorEmpresa adaptadorEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        photoImageView = (ImageView) findViewById(R.id.photoImageView);
        nombreTextView = (TextView) findViewById(R.id.nameTextView);
        emailTextView = (TextView) findViewById(R.id.emailTextView);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        firebaseAuth = FirebaseAuth.getInstance();
        firebaAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    setUserData(user);
                }else{
                    goLogInScreen();
                }
            }
        };

        bd.conectarFirebaseContactos();
        bd.conectarFirebaseEmpresas();

        listaContactos = bd.getListaContactos();
        listaEmpesas = bd.getListaEmpresas();

        adaptador = new AdaptadorContacto(this, listaContactos);
        adaptadorEmpresa = new AdaptadorEmpresa(this, listaEmpesas);

        this.setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        fab1(); fab2(); fab3();

        }

    private void setUserData(FirebaseUser user) {

        nombreTextView.setText(user.getDisplayName());
        emailTextView.setText(user.getEmail());
        Glide.with(this).load(user.getPhotoUrl()).into(photoImageView);
    }

    @Override
    protected void onStart() {
        super.onStart();

        firebaseAuth.addAuthStateListener(firebaAuthListener);
    }

    private void goLogInScreen() {

        Intent intent = new Intent(this, Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK );
        startActivity(intent);
    }

    public void logOut(View view){
        firebaseAuth.signOut();

        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()){
                    goLogInScreen();
                }else{
                    Toast.makeText(getApplicationContext(), "No se pudo cerrar sesion", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.contactosNav) {
            Intent intent = new Intent(this, ListaContactos.class);
            startActivity(intent);

        } else if (id == R.id.empresaNav) {
            Intent intent = new Intent(this, ListaEmpresas.class);
            startActivity(intent);

        } else if (id == R.id.about) {
            AlertDialog.Builder about = new AlertDialog.Builder(MainActivity.this);
            about.setTitle("Acerca de la aplicacion:");
            about.setMessage("SocialTech es una agenda de contactos profesional que almacena datos de contactos " +
                    "relacionados con el sector de la tecnología para " +
                    "la búsqueda de empleo.\n" +
                    "\n"+"SocialTech ha sido desarrollado como proyecto de la asignatura 'Desarrollo de Interfazes'" +
                    " cuyo objetivo es el aprendizaje de android. \n " +
                    "\nEsta version aún esta en Alpha con algunos Bugs.\n" +
                    "\n::app:: Realizada por: Daniel Sierra Ráez\n" +
                    "\n:: GITHUB ::\nhttps://github.com/Carets12");
            about.setCancelable(false);

            about.setPositiveButton("Okey :)",new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            about.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    
    public void fab1(){
        contadorFab = 0;
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorFab++;
                visibleFab();
            }
        });
    }

    public void fab2(){
        contadorFab = 0;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorFab++;
                fragmentManager.beginTransaction().replace(R.id.contenido, new Formulario()).commit();

                visibleFab();
            }
        });
    }

    public void fab3(){
        contadorFab = 0;
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorFab++;
                fragmentManager.beginTransaction().replace(R.id.contenido, new FormularioEmpresa()).commit();

              visibleFab();
            }
        });
    }

    public void visibleFab(){
        if (1 == contadorFab%2){
            fab.setVisibility(View.VISIBLE);
            fab2.setVisibility(View.VISIBLE);
        }else{
            fab.setVisibility(View.INVISIBLE);
            fab2.setVisibility(View.INVISIBLE);
        }
    }

    public static ArrayList<Contacto> getListaContactos() {
        return listaContactos;
    }

    public static ArrayList<Empresa> getListaEmpesas() {
        return listaEmpesas;
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(firebaAuthListener != null){
            firebaseAuth.removeAuthStateListener(firebaAuthListener);
        }
    }
}
