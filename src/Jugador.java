public class Jugador {
     public int codPais;
     public String nombrePais;
     public String nombreJugador;
     public int anoNacimiento;
     public float altura;
     public String clubProcedencia;


     public Jugador(int codPais,String nombrePais,String nombreJugador,int anoNacimiento,float altura,String clubProcedencia){
          this.codPais = codPais;
          this.nombrePais= nombrePais;
          this.nombreJugador= nombreJugador;
          this.anoNacimiento= anoNacimiento;
          this.altura= altura;
          this.clubProcedencia= clubProcedencia;
     }
     public int getCodPais(){
          return codPais;
     }

     public void setCodPais(int codPais) {
          this.codPais = codPais;
     }
     public String getNombrePais(){
          return nombrePais;
     }
     public void setNombrePais(String nombrePais) {
          this.nombrePais = nombrePais;
     }
     public String getNombreJugador(){
          return nombreJugador;
     }
     public void setNombreJugador(String nombreJugador) {
          this.nombreJugador = nombreJugador;
     }
     public int getAnoNacimiento() {
          return anoNacimiento;
     }

     public void setAnoNacimiento(int anoNacimiento) {
          this.anoNacimiento = anoNacimiento;
     }
          public float getAltura() {
               return altura;
          }
     public void setAltura(float altura) {
          this.altura = altura;
     }
     public String getClubProcedencia(){
          return clubProcedencia;
     }

     public void setClubProcedencia(String clubProcedencia) {
          this.clubProcedencia = clubProcedencia;
     }










}
