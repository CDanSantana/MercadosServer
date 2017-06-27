package mercadosServer;

import java.sql.*;

public class MercadosServer {

public String listaDeMercados(String cidade, String bairro, String rua){
String resultado="";
try{
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mercados?useUnicode=true&amp;characterEncoding=UTF-8","root","");
PreparedStatement statement =  con.prepareStatement("select * from mercados where merc_cidade=? and merc_bairro like ? or merc_rua like ? ;");
ResultSet result = statement.executeQuery();
if(result.isBeforeFirst()==false){
while(result.next()){
resultado=resultado+result.getString("merc_nome")+"|";
}
}else{
resultado="Não foram encontrados mercados próximos a você...";
}
result.close();
con.close();
}catch(Exception e){
resultado="Ocorreu um erro!";
}
return(resultado);
}

}
