package com.application.genius.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Firebase {
    private static DatabaseReference databaseReference;
    private static FirebaseAuth firebaseAuth;

    //RETORNA A REFERÊNCIA DO BANCO
    public static DatabaseReference getDatabaseReference() {
        if(databaseReference == null){
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            databaseReference = FirebaseDatabase.getInstance().getReference();
        }
        return databaseReference;
    }

    //RETORNA A INSTÂNCIA DO FIREBASE AUTH
    public static FirebaseAuth getFirebaseAuth() {
        if (firebaseAuth == null){
            firebaseAuth = FirebaseAuth.getInstance();
        }
        return firebaseAuth;
    }
}
