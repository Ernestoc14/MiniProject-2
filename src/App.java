// En una farmacia se necesita una aplicación para administrar su inventario de
// medicamentos. El empleado de dicha farmacia va acomodar los medicamentos en tres
// anaqueles alfabéticamente por el laboratorio. 
// (anaquel 1: A-F, anaquel 2: G-P y anaquel 3: Q-Z). 
//La información que se tiene del medicamento es código, nombre comercial,
// nombre genérico, laboratorio, existencia, fechadecaducidad(MM/AAAA),
// fechaderegistro(dia-mes-año). La aplicación debe contar con las siguientes opciones

//Nombre com, gen, exit, COMUN
//1-F Cad
//2-Lab
//3-Lab, F Cad

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
    // private char[] sex;
    // //Sexo setter method  
    // public void setUserSex(char[] sex){
    //     this.sex = sexo;
    // }
    // //sexo getter method
    // public char[] getUserSex(){
    //     return sexo;
    // }
    // //PESO
    // private double[] pes;
    // //Peso setter method 
    // public void setUserPeso(double[] pes){
    //     this.pes = peso;
    // }
    // //sexo getter method
    // public double[] getUserPeso(){
    //     return pes;
    // }


    Scanner sn = new Scanner(System.in);
    
    String[] medicamento = new String[5]; //Para el medicamento
    String []laboratorio = new String[5]; //Para el laboratorio

    //GENERALES
    String [][] AnaquelAF = new String [2][5]; //Anaquel de A-F
    String [][] AnaquelGP = new String [2][5]; //Anaquel de G-P
    String [][] AnaquelQZ = new String [2][5]; //Anaquel de Q-Z     
    String [][] MedInfo = new String [10][7]; //Almacenamos la Info del Med como nombres, lab, fechas, Codigo...
    public void MenuOpc(int opc)
    {   App pr = new App();
        switch (opc) {
            case 1: //Registrar Laboratorios
                pr.RegistrarLab(laboratorio, MedInfo);
                break;
            case 2: //Definir los Anaqueles
                pr.DefAnaq(AnaquelAF, AnaquelGP, AnaquelQZ, MedInfo);
                break;
            case 3: //Registrar medicamentos en el inventario
                pr.RegistrarMedEnInventario(AnaquelAF, AnaquelGP, AnaquelQZ, MedInfo, medicamento);
                break;
            case 4: //El Peso de la persona mas pesada
                
                break;
            case 5: //Numero de personas con contextura delgada por sexo 
                
                break;
            case 6: //Numero de personas con contextura mediana por sexo 
                
                break;
            case 7: //Numero de personas con contextura gruesa por sexo 
                
                break;
            case 8: //Salir
                break;
            default:
                break;
        }
    }
    public void RegistrarLab(String []laboratorio, String[][] MedInfo)  //OPCION 1
    {   //App pr = new App();
        int opc=0,wi=0;
        System.out.println("Desea registrar un laboratorio? 1-Si 2-No: ");
        opc = sn.nextInt();
        sn.nextLine();
        while(opc==1)
        {   System.out.printf("Deme el nombre del laboratorio %d: ",wi+1);
            laboratorio[wi] = sn.nextLine();
            MedInfo[wi][3] = laboratorio[wi];
            wi++;
            System.out.println("Desea registrar otro laboratorio? 1-Si 2-No: ");
            opc = sn.nextInt();
            sn.nextLine();
        }
        //pr.setUserSex(sex);
    }
    public void DefAnaq(String [][] AnaquelAF, String [][] AnaquelGP, String [][] AnaquelQZ, String [][] MedInfo) //OPCION 2
    {   //App pr = new App();
        int opc=0,wi=0;
        System.out.println("Desea definir un anaquel? 1-Si 2-No: ");
        opc = sn.nextInt();
        sn.nextLine();
        while(opc==1)
        {   System.out.printf("Deme el peso de la persona %d :", wi+1);
            wi++;
            System.out.print("Desea definir otro anaquel? 1-Si 2-No: ");
            opc = sn.nextInt();
            sn.nextLine();
        }
        //pr.setUserPeso(peso);
    }
    public void RegistrarMedEnInventario(String [][] AnaquelAF, String [][] AnaquelGP, String [][] AnaquelQZ, String [][] MedInfo, String [] medicamento) //OPCION 3 
    {    //App pr = new App();
        int opc=0,wi=0;
        String lab;
        System.out.println("Desea registrar un Medicamento en el Inventario? 1-Si 2-No: ");
        opc = sn.nextInt();
        sn.nextLine();
        while(opc==1)
        {   System.out.printf("Deme el nombre comercial del medicamento :");
            medicamento[wi] = sn.nextLine();
            MedInfo[wi][0] = medicamento[wi]; //Nomb Comercial  0
            System.out.printf("Deme el nombre generico del medicamento :");
            MedInfo[wi][1] = sn.nextLine();  //Nomb Generico   1
            System.out.printf("Deme la existencia del medicamento %s:",MedInfo[wi][0]);
            MedInfo[wi][2] = sn.nextLine();  //Existencia  2
           
            System.out.printf("Deme la fecha de caducidad del medicamento %s en formato MM/AAAA :",MedInfo[wi][0]);
            MedInfo[wi][4] = sn.nextLine(); //Fecha de Caducidad  4
            System.out.printf("Deme la fecha de registro del medicamento %s en formato D/MM/AA :",MedInfo[wi][0]);
            MedInfo[wi][5] = sn.nextLine(); //Fecha de Registro  5
            System.out.printf("Deme el codigo del medicamento %s: ",MedInfo[wi][0]);
            MedInfo[wi][6] = sn.nextLine();  //Codigo 6

            lab = MedInfo[wi][3];  //Laboratorio 3
            char firstletter = lab.charAt(0);

            if( Character.toString(firstletter).matches("[A-F?]") )  //Anaquel 1
            {   AnaquelAF [0][wi] = MedInfo[wi][3];  // Laboratorio
                AnaquelAF [1][wi] = MedInfo[wi][0]; //Nombre Comercial
                System.out.printf("El medicamento %s se agrego al Anaquel 1", MedInfo[wi][0]);
            }
            else
            {   if( Character.toString(firstletter).matches("[G-P?]") )  //Anaquel 2
                {   AnaquelGP [0][wi] = MedInfo[wi][3];  // Laboratorio
                    AnaquelGP [1][wi] = MedInfo[wi][0]; //Nombre Comercial
                    System.out.printf("El medicamento %s se agrego al Anaquel 2", MedInfo[wi][0]);
                }
                else
                {   if( Character.toString(firstletter).matches("[Q-Z?]") )  //Anaquel 3
                    {   AnaquelQZ [0][wi] = MedInfo[wi][3];  // Laboratorio
                        AnaquelQZ [1][wi] = MedInfo[wi][0]; //Nombre Comercial
                        System.out.printf("El medicamento %s se agrego al Anaquel 3", MedInfo[wi][0]);
                    }
                    else
                    {   System.out.println("Error");
                    }
                }
            }
            wi++;
            System.out.print("\nDesea registrar otro Medicamento en el Inventario? 1-Si 2-No: ");
            opc = sn.nextInt();
            sn.nextLine();
        }
        //pr.setUserSex(sex);
    }
    
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        App pr = new App();
        int y=0,opc=0;
        do{ System.out.println("--------------------------------Menu Principal---------------------------------");
            System.out.println("1.Registrar Laboratorios ");
            System.out.println("2.Definir los Anaqueles ");
            System.out.println("3.Registrar medicamentos en el inventario ");
            System.out.println("4.Consultar medicamentos de un Laboratorio X ");
            System.out.println("5.Consultar los laboratorios que proveen un medicamento X utilizando el nombre genérico ");
            System.out.println("6.Consultar medicamentos cuya cantidad está por debajo de una cantidad X ");
            System.out.println("7.Consultar medicamentos que vencen en un mes X y año X ");
            System.out.println("8.Consultar los medicamentos que vencen en los próximos N meses ");
            System.out.println("9.Consultar los medicamentos almacenados en un anaquel X ");
            System.out.println("10.Salir ");
            System.out.print("Introduzca la opcion a realizar:");
            opc = sn.nextInt();
            pr.MenuOpc(opc);
            System.out.print("\nDesea realizar otra opcion? 1-Si 2-No: ");
            y = sn.nextInt();
        }while(y==1);
        sn.close();
    }


//Sexo class con atributo sex
//     public class Sexo{
//         private char sex;
//     //Setter del valor de sex
//         public Sexo(char sex){
//             this.sex = sex;
//         }
//     //getter del valor de sex
//         public char getSex(){
//             return sex;
//         }
//     }   
// //Peso class con atributo pes
//     public class Peso{
//         private double pes;
//     //Setter del valor de pes
//         public Peso(double pes){
//         this.pes = pes;
//         }
//     //getter del valor de sex
//         public double getPes(){
//         return pes;
//         }
//     } 
}