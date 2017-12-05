package com.example.rodrigo.navview.Database;

/**
 * Created by Rodrigo on 04/12/2017.
 */

public class ScriptSQL {
    public static String getCreateCadastro(){
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("CREATE TABLE IF NOT EXISTS CADASTRO (");
        sqlBuilder.append("email TEXT PRIMARY KEY NOT NULL,");
        sqlBuilder.append("senha TEXT NOT NULL,");
        sqlBuilder.append("nome TEXT NOT NULL);");

        return sqlBuilder.toString();
    }
}
