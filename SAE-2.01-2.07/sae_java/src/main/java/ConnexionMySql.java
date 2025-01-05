

import java.sql.*;

public class ConnexionMySql {
    
	private Connection mysql;

	public ConnexionMySql() throws SQLException{
		this.mysql = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/saef","root","4dameorc");
                }

                
	/*public ConnexionMySql(String leGens) throws SQLException{
        this.mysql = DriverManager.getConnection(
                     "jdbc:mysql://servinfo-maria:3306/DB"+leGens,leGens,leGens);
                    //"jdbc:mysql://servinfo-maria:3306/DBmarques","marques","marques");
					// "jdbc:mysql://"+nomServeur+":3306/"+nomBase,nomLogin, motDePasse);

    } */


	public void close() throws SQLException {
		this.mysql.close();
	}
    public Statement createStatement() throws SQLException {
        if (this.mysql == null) {
            throw new SQLException("pas connecté");
        }
        return this.mysql.createStatement();
    }


	public PreparedStatement prepareStatement(String requete) throws SQLException{
		return this.mysql.prepareStatement(requete);
	}


    public void executeQuery(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'executeQuery'");
    }
	
}
