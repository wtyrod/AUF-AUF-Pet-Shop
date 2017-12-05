package com.example.rodrigo.navview.Mensagem;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Rodrigo on 04/12/2017.
 */

public class mensagens {
    public static void alertaDialog(Context context, String msg, String title){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(msg);
        builder.setNeutralButton("OK", null);

        builder.show();
    }

    public static void toast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
