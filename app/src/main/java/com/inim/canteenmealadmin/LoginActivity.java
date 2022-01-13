package com.inim.canteenmealadmin;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.ProgressBar;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.android.material.button.MaterialButton;
        import com.google.android.material.textfield.TextInputEditText;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText etemail,etpassword;
ProgressBar progressBar;
    MaterialButton btnLogin;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etemail = findViewById(R.id.etMail);
        etpassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
progressBar=findViewById(R.id.progressBar);
progressBar.setVisibility(View.INVISIBLE);
        mAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
                progressBar.setVisibility(View.VISIBLE);
            }
        });


    }

    private void loginUser() {
        String email = etemail.getText().toString();
        String password = etpassword.getText().toString();

        if(TextUtils.isEmpty(email)){
            etemail.setError("Email cannot be empty");
            etemail.requestFocus();
        }else if(TextUtils.isEmpty(password)){
            etpassword.setError("Password cannot be empty");
            etpassword.requestFocus();
        }else {
            if(email.equals("canteenmeal4@gmail.com")) {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "User Logged in Successfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        } else {
                            Toast.makeText(LoginActivity.this, "Log In Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else{
                Toast.makeText(getApplicationContext(), "invalid user", Toast.LENGTH_SHORT).show();
            }

        }
    }
}