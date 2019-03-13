package ekrmadonate;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.awad.ekrma.ekrmadonate.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

        //1.add auth to project
        //2.
        FirebaseAuth auth;// to establish sign in sign up
        FirebaseUser user;//user

        private EditText etfirstname;
        private EditText etlastname;
        private EditText etemail2;
        private EditText etphone;
        private EditText etpassword2;
        private Button btnsave;
        private String passw;
        private String email3;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_signup);
            //3.
            auth = FirebaseAuth.getInstance();
            user = auth.getCurrentUser();//

            etfirstname = (EditText) findViewById(R.id.etfirstname);
            etlastname = (EditText) findViewById(R.id.etlastname);
            etemail2 = (EditText) findViewById(R.id.etemail2);
            etphone = (EditText) findViewById(R.id.etphone);
            etpassword2 = (EditText) findViewById(R.id.etpassword2);
            btnsave = (Button) findViewById(R.id.btnsave);

            btnsave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dataHandler();

                }
            });
        }

        /**
         * get email and password from the field and try to create new user
         */
        private void dataHandler() {
            boolean isok = true;// if all the fields filled well
            String email = etemail2.getText().toString();
            String passw1 = etpassword2.getText().toString();
            String fname = etfirstname.getText().toString();
            String lname = etlastname.getText().toString();
            String phone = etphone.getText().toString();
            if (email.length() < 4 || email.indexOf('@') < 0 || email.indexOf('.') < 0) {
                etemail2.setError("Wrong Email");
                isok = false;
            }
            if (etpassword2.length() < 8) {
                etpassword2.setError("Have to be at least 8 char");
                isok = false;
            }
            if (isok) {
                creatAcount(email, passw1);
            }

        }

        //4.

        /**
         * create firebase user using email and password
         *
         * @param email user email
         * @param passw user password
         */

        private void creatAcount(String email, String passw) {
            auth.createUserWithEmailAndPassword(email, passw).addOnCompleteListener( SignupActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText( SignupActivity.this, "Authentication Successful.", Toast.LENGTH_SHORT).show();
                        //updateUserProfile(task.getResult().getUser());
                        finish();
                    } else {
                        Toast.makeText( SignupActivity.this, "Authentication failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        task.getException().printStackTrace();
                    }
                }
            });
        }

    }

