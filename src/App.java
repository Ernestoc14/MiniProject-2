// En una farmacia se necesita una aplicación para administrar su inventario de
// medicamentos. El empleado de dicha farmacia va acomodar los medicamentos en tres
// anaqueles alfabéticamente por el laboratorio. 
// (anaquel 1: A-F, anaquel 2: G-P y anaquel 3: Q-Z). 
//La información que se tiene del medicamento es código, nombre comercial,
// nombre genérico, laboratorio, existencia, fechadecaducidad(MM/AAAA),
// fechaderegistro(dia-mes-año). La aplicación debe contar con las siguientes opciones

// 1-Registrar Laboratorios(crear, editar y eliminar)
// 2-Definir los Anaqueles(crear, editar y eliminar)
// 3-Registrar medicamentos en el inventario(se debe poder editar y eliminar)
// 4-Consultar medicamentos de un Laboratorio X (Listar nombre comercial, nombre
// genérico, existencia, fecha de caducidad).
// 5-Consultar los laboratorios que proveen un medicamento X utilizando el nombre
// genérico.
// 6-Consultar medicamentos cuya cantidad está por debajo de una cantidad X(Listar
// nombre comercial, nombre genérico, laboratorio y existencia).
// 7-Consultar medicamentos que vencen en un mes X y año X. (Listar nombre
// comercial, nombre genérico, laboratorio, existencia y fecha de caducidad).
// 8-Consultar los medicamentos que vencen en los próximos N meses(Listar nombre
// comercial, nombre genérico, laboratorio, existencia y fecha de caducidad).
// 9-Consultar los medicamentos almacenados en un anaquel X(Listar nombre
// comercial, nombre genérico, laboratorio y existencia)


import java.util.Scanner;
public class App {
    //SEXO 
    private char[] sex;
    //Sexo setter method 
    public void setUserSex(char[] sex){
        this.sex = sexo;
    }
    //sexo getter method
    public char[] getUserSex(){
        return sexo;
    }
    //PESO
    private double[] pes;
    //Peso setter method 
    public void setUserPeso(double[] pes){
        this.pes = peso;
    }
    //sexo getter method
    public double[] getUserPeso(){
        return pes;
    }
    Scanner sn = new Scanner(System.in);
    char [] sexo = new char [15]; //Para sexo
    double [] peso = new double [15]; //Para peso
    double TotaldePeso=0;

    public void MenuOpc(int opc)
    {   App pr = new App();
        switch (opc) {
            case 1: //Ingresar Sexo
                pr.IngresarSexo(sexo);
                break;
            case 2: //Ingresar Peso
                pr.IngresarPeso(peso);
                break;
            case 3: //Mostrar Promedio
                pr.MostrarPromedio(TotaldePeso,peso);
                break;
            case 4: //El Peso de la persona mas pesada
                pr.PersonaMasPesada(peso);
                break;
            case 5: //Numero de personas con contextura delgada por sexo 
                pr.DelgadaXSexo(peso);
                break;
            case 6: //Numero de personas con contextura mediana por sexo 
                pr.MedianaXSexo(peso);
                break;
            case 7: //Numero de personas con contextura gruesa por sexo 
                pr.GruesaXSexo(peso);
                break;
            case 8: //Salir
                break;
            default:
                break;
        }
    }
    public void IngresarSexo(char []sexo)  //OPCION 1
    {   App pr = new App();
        int opc=0,wi=0;
        char verif=' ';
        System.out.println("Desea ingresar el sexo de un usuario? 1-Si 2-No: ");
        opc = sn.nextInt();
        while(opc==1)
        {   System.out.printf("Deme el sexo de la persona %d :",wi+1);
            verif = sn.next().charAt(0);
            if((verif=='f')||(verif=='m')){
                sexo[wi] = verif;
            }
            wi++;
            System.out.print("Desea ingresar el sexo de un usuario? 1-Si 2-No: ");
            opc = sn.nextInt();
        }
        pr.setUserSex(sex);
    }
    public void IngresarPeso(double []peso) //OPCION 2
    {   App pr = new App();
        int opc=0,wi=0;
        System.out.println("Desea ingresar el peso de un usuario? 1-Si 2-No: ");
        opc = sn.nextInt();
        while(opc==1)
        {   System.out.printf("Deme el peso de la persona %d :",wi+1);
            peso[wi]=sn.nextDouble();
            wi++;
            System.out.print("Desea ingresar el sexo de un usuario? 1-Si 2-No: ");
            opc = sn.nextInt();
        }
        pr.setUserPeso(peso);
    }
    public void MostrarPromedio(double TotaldePeso, double []peso) //OPCION 3 
    {   double PesoProm=0;
        for(int fi=0;fi<peso.length;fi++)
        {   TotaldePeso = TotaldePeso + peso[fi];
        }
        PesoProm = TotaldePeso/peso.length;
        System.out.printf("El peso promedio es de %.2f ", PesoProm);
    }
    public void PersonaMasPesada(double []peso)  //OPCION 4
    {   double mayor = peso[0];
        for(int fi=0;fi<peso.length;fi++)
        {   if(peso[fi] > mayor){
            mayor = peso[fi];
            }
        }
        System.out.printf("La persona mas pesada peso %.2f ",mayor);
    }
    public void DelgadaXSexo(double []peso) //OPCION 5
    {   int delgadas=0;
        for(int fi=0;fi<peso.length;fi++)
        {   if(peso[fi] < 53 ){
            delgadas++;
            }
        }
        System.out.printf("Hay %d personas delgadas en el gimnasio ",delgadas);
    }
    public void MedianaXSexo(double []peso) //OPCION 6
    {   int medianas=0;
        for(int fi=0;fi<peso.length;fi++)
        {   if((peso[fi] >= 53) && (peso[fi]<=60)){
            medianas++;
            }
        }
        System.out.printf("Hay %d personas medianas en el gimnasio ",medianas);
    }
    public void GruesaXSexo(double []peso) //OPCION 7
    {   int gruesas=0;
        for(int fi=0;fi<peso.length;fi++)
        {   if(peso[fi] > 60){
            gruesas++;
            }
        }
        System.out.printf("Hay %d personas medianas en el gimnasio ",gruesas);
    }
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        App pr = new App();
        int y=0,opc=0;
        do{ System.out.println("--------------------------------Menu-----------------------------------------------");
            System.out.println("1.Ingresar Sexo ");
            System.out.println("2.Ingresar Peso ");
            System.out.println("3.Mostrar Promedio ");
            System.out.println("4.El Peso de la persona mas pesada ");
            System.out.println("5.Numero de personas con contextura delgada por sexo ");
            System.out.println("6.Numero de personas con contextura mediana por sexo ");
            System.out.println("7.Numero de personas con contextura gruesa por sexo ");
            System.out.println("8.Salir ");
            System.out.print("Introduzca la opcion a realizar:");
            opc = sn.nextInt();
            pr.MenuOpc(opc);
            System.out.print("\nDesea realizar otra opcion? 1-Si 2-No: ");
            y = sn.nextInt();
        }while(y==1);
        sn.close();
    }


//Sexo class con atributo sex
    public class Sexo{
        private char sex;
    //Setter del valor de sex
        public Sexo(char sex){
            this.sex = sex;
        }
    //getter del valor de sex
        public char getSex(){
            return sex;
        }
    }   
//Peso class con atributo pes
    public class Peso{
        private double pes;
    //Setter del valor de pes
        public Peso(double pes){
        this.pes = pes;
        }
    //getter del valor de sex
        public double getPes(){
        return pes;
        }
    } 
}