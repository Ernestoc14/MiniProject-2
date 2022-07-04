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
    String [][] AnaquelAF = new String [2][5]; //Anaquel de A-F 2-Lab y Med 5-Cant de Lab y Med
    String [][] AnaquelGP = new String [2][5]; //Anaquel de G-P
    String [][] AnaquelQZ = new String [2][5]; //Anaquel de Q-Z     
    String [][] MedInfo = new String [5][7]; //Almacenamos la Info del Med como nombres, lab, fechas, Codigo... 5-Cant de Meds 
    //Para listar la impresion segun el Caso usare arrays [][]
    // String [][] Case69 = new String [10][4]; //10 Medicamentos 4 Items a listar
    // String [][] Case78 = new String [10][5]; //10 Medicamentos 5 Items a listar
    public void MenuOpc(int opc)
    {   App pr = new App();
        switch (opc) {
            case 1: //Registrar Laboratorios
                pr.RegistrarLab(laboratorio, MedInfo);  // La primera letra de Laboratorio debe ser MAYUS
                break;
            case 2: //Definir los Anaqueles
                pr.DefAnaq(AnaquelAF, AnaquelGP, AnaquelQZ, MedInfo);
                break;
            case 3: //Registrar medicamentos en el inventario
                pr.RegistrarMedEnInventario(AnaquelAF, AnaquelGP, AnaquelQZ, MedInfo, medicamento);
                break;
            case 4: //Consultar medicamentos de un Laboratorio X 
                pr.MedEnLabX(MedInfo);  //Impresion Unica
                break;
            case 5: //Consultar los laboratorios que proveen un medicamento X utilizando el nombre genérico
                pr.LabConMedXUsingNombreGen(MedInfo);
                break;
            case 6: //Consultar medicamentos cuya cantidad está por debajo de una cantidad X 
                pr.MedConCantMenor(MedInfo); //Impresion igual a Case 9
                break;
            case 7: //Consultar medicamentos que vencen en un mes X y año X
                pr.MedVencenMesYearX(MedInfo); //Impresion igual a Case 8
                break;
            case 8: //Consultar los medicamentos que vencen en los próximos N meses
                pr.MedVencenProxMes(MedInfo);  //Impresion igual a Case 7 
                break;
            case 9: //Consultar los medicamentos almacenados en un anaquel X
                pr.MedEnAnaquelX(AnaquelAF, AnaquelGP, AnaquelQZ, MedInfo);  //Impresion igual a Case 6
                break;
            case 10: //Salir
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
        {   if(wi == 0 )  //Anaquel 1
            {   System.out.printf("El Anaquel 1 estara definido desde la A hasta la F");
            }
            else
            {   if( wi==1 )  //Anaquel 2
                {   System.out.printf("El Anaquel 2 estara definido desde la G hasta la P");
                }
                else
                {   if( wi==2 )  //Anaquel 3
                    {   System.out.printf("El Anaquel 3 estara definido desde la Q hasta la Z");
                    }
                    else
                    {   System.out.println("Error, ya no existen mas anaqueles");
                    }
                }
            }
            wi++;
            System.out.print("\nDesea definir otro anaquel? 1-Si 2-No: ");
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
                AnaquelAF [1][wi] = MedInfo[wi][0]; //Nombre Comercial Medicamento
                System.out.printf("El medicamento %s se agrego al Anaquel 1", MedInfo[wi][0]);
            }
            else
            {   if( Character.toString(firstletter).matches("[G-P?]") )  //Anaquel 2
                {   AnaquelGP [0][wi] = MedInfo[wi][3];  // Laboratorio
                    AnaquelGP [1][wi] = MedInfo[wi][0]; //Nombre Comercial Medicamento
                    System.out.printf("El medicamento %s se agrego al Anaquel 2", MedInfo[wi][0]);
                }
                else
                {   if( Character.toString(firstletter).matches("[Q-Z?]") )  //Anaquel 3
                    {   AnaquelQZ [0][wi] = MedInfo[wi][3];  // Laboratorio
                        AnaquelQZ [1][wi] = MedInfo[wi][0]; //Nombre Comercial Medicamento
                        System.out.printf("El medicamento %s se agrego al Anaquel 3", MedInfo[wi][0]);
                    }
                    else
                    {   System.out.println("Error, el medicamento no se agrego a ningun Anaquel");
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
    public void MedEnLabX(String [][] MedInfo) //OPCION 4
    {   String labconsul;
        int opc=1, wi=0;
        while(opc==1)
        {   System.out.printf("Deme el nombre del laboratorio a consultar: ");
            labconsul = sn.nextLine(); //Nombre del Laboratorio
            if( labconsul.equals(MedInfo[wi][3]) )
            {   System.out.printf("Medicamento %d del laboratorio %s ",wi+1,labconsul);
                System.out.printf("\nNombre Comercial: %s \nNombre Generico: %s \nExistencia: %s \nFecha de Caducidad: %s ",MedInfo[wi][0],MedInfo[wi][1],MedInfo[wi][2],MedInfo[wi][4]);
            }
            wi++;
            System.out.print("\nDesea consultar otro laboratorio? 1-Si 2-No: ");
            opc = sn.nextInt();
            sn.nextLine();
        }
    }
    public void LabConMedXUsingNombreGen(String [][] MedInfo) //OPCION 5
    {   String medconsul;
        int opc=1; //,wi=0;
        while(opc==1)
        {   System.out.printf("Deme el nombre generico del medicamento a consultar: ");
            medconsul = sn.nextLine();  //Nomb Generico
            int wi=0; //Debuggear
            if( medconsul.equals(MedInfo[wi][1]) )
            {   System.out.printf("El Laboratorio %s provee el medicamento %s",MedInfo[wi][3],medconsul); //Nombre Generico
            }
            else
            {   System.out.printf("Ningun laboratorio provee el medicamento %s",medconsul);
            }
            wi++;
            System.out.print("\nDesea consultar otro medicamento? 1-Si 2-No: ");
            opc = sn.nextInt();
            sn.nextLine();
        }
    }
    public void MedConCantMenor(String [][] MedInfo) //OPCION 6 //Debuggear
    {   //String cantidad;
        int fi=0,cantidad=0,existencia=0;
        System.out.printf("Deme la cantidad del medicamento a consultar: ");
        cantidad = sn.nextInt();  //Cantidad
        for(fi=0;fi<=5;fi++)
        {   existencia = Integer.parseInt(MedInfo[fi][2]);
            if( existencia < cantidad )
            {   System.out.printf("\nMedicamento con cantidad debajo de %d", cantidad);
                System.out.printf("\nNombre Comercial: %s \nNombre Generico: %s \nLaboratorio: %s \nExistencia: %s  ",MedInfo[fi][0],MedInfo[fi][1],MedInfo[fi][3],MedInfo[fi][2]);
            }
        }        
    }
    public void MedVencenMesYearX(String [][] MedInfo) //OPCION 7
    {   //Consultar los med que vencen en mes y anio X
        String MatchFecha; //= "2021/13"; // Fecha a comparar con la dada en la info del Medicamento
        int opc=0;
        System.out.println("Deme la fecha de caducidad a consultar: ");
        MatchFecha = sn.nextLine();
        //Date strDate = new SimpleDateFormat("yyyy/MM").parse(MatchFecha);
        while(opc == 1)
        {   //Date strDate2 = new SimpleDateFormat("yyyy/MM").parse(MedInfo[iteration][4]);
            int fi=0;
            if(MatchFecha.equals(MedInfo[fi][4]))
            {   System.out.printf("Hemos encontrado un medicamento que vence en: %s",MatchFecha);
                System.out.printf("\nNombre Comercial: %s \nNombre Generico: %s \nLaboratorio: %s \nExistencia: %s  \nFecha de Caducidad: %s",MedInfo[fi][0],MedInfo[fi][1],MedInfo[fi][3],MedInfo[fi][2],MedInfo[fi][4]);
            }
            else{
                System.out.printf("No encontramos medicamentos que caduquen en: %s",MatchFecha);
            }
            fi++;
            System.out.print("\nDesea consultar otra fecha de caducidad? 1-Si 2-No: ");
            opc = sn.nextInt();
            sn.nextLine();

        }
    }    
    public void MedVencenProxMes(String [][] MedInfo) //OPCION 8
    {   //Consultar los med que vencen en los proximos N Meses
        //using date for Format
        String MatchFecha; 
        int opc=0;
        System.out.println("Deme la fecha de caducidad a consultar: ");
        MatchFecha = sn.nextLine();
        while(opc == 1)
        {   int fi=0;
            if(MatchFecha.equals(MedInfo[fi][4]))
            {   System.out.printf("Hemos encontrado un medicamento que vence en: %s",MatchFecha);
                System.out.printf("\nNombre Comercial: %s \nNombre Generico: %s \nLaboratorio: %s \nExistencia: %s  \nFecha de Caducidad: %s",MedInfo[fi][0],MedInfo[fi][1],MedInfo[fi][3],MedInfo[fi][2],MedInfo[fi][4]);
            }
            else{
                System.out.printf("No encontramos medicamentos que caduquen en: %s",MatchFecha);
            }
            fi++;
            System.out.print("\nDesea consultar otra fecha de caducidad? 1-Si 2-No: ");
            opc = sn.nextInt();
            sn.nextLine();

        }
    }
    public void MedEnAnaquelX(String [][] AnaquelAF, String [][] AnaquelGP, String [][] AnaquelQZ, String [][] MedInfo) //OPCION 9
    {   //Consultar las Med en un anaquel X
        int AnaqConsulta=0;
        System.out.printf("Deme el Anaquel a consultar: ");
        AnaqConsulta = sn.nextInt();  //Cantidad
        if (AnaqConsulta == 1)
        {   System.out.printf("\nLos medicamentos del Anaquel 1 [A-F] son: ");
            for(int fa=0;fa<=5;fa++)
            {   System.out.printf("El medicamento %d del Anaquel %d: " ,fa ,AnaqConsulta );
                System.out.printf("\nNombre Comercial: %s \nNombre Generico: %s \nLaboratorio: %s \nExistencia: %s  ",MedInfo[fa][0],MedInfo[fa][1],MedInfo[fa][3],MedInfo[fa][2]);
            } //Fin For 1
        }//Fin If 1
        else
        {   if( AnaqConsulta == 2)
            {   System.out.printf("\nLos medicamentos del Anaquel 2 [G-P] son: ");
                for(int fa=0;fa<=5;fa++)
                {   System.out.printf("El medicamento %d del Anaquel %d: " ,fa ,AnaqConsulta );
                    System.out.printf("\nNombre Comercial: %s \nNombre Generico: %s \nLaboratorio: %s \nExistencia: %s  ",MedInfo[fa][0],MedInfo[fa][1],MedInfo[fa][3],MedInfo[fa][2]);
                } //Fin For 2
            } // Fin If 2
            else
            {   if( AnaqConsulta == 3)
                {   System.out.printf("\nLos medicamentos del Anaquel 3 [Q-Z] son: ");
                    for(int fa=0;fa<=5;fa++)
                    {   System.out.printf("El medicamento %d del Anaquel %d: " ,fa ,AnaqConsulta );
                        System.out.printf("\nNombre Comercial: %s \nNombre Generico: %s \nLaboratorio: %s \nExistencia: %s  ",MedInfo[fa][0],MedInfo[fa][1],MedInfo[fa][3],MedInfo[fa][2]);
                    } //Fin For 3
                } // Fin If 3
            }// Fin Else 2
        }//Fin else 1
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
            System.out.println("Desea realizar otra opcion? 1-Si 2-No: ");
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