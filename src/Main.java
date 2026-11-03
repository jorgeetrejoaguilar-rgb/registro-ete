import java.util.Scanner;

class Main
{
    public static void main(String args[])
    {
        Scanner teclado = new Scanner(System.in);
        Registro reg = new Registro(teclado);
        int opcion;

        do
        {
            System.out.println("\n--- REGISTRO ETE ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Capturar calificaciones");
            System.out.println("3. Consulta de datos");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(teclado.nextLine());

            switch (opcion)
            {
                case 1: 
                    reg.registrar();     
                    break;
                case 2: 
                    reg.capturarCalif(); 
                    break;
                case 3: 
                    reg.consultar();     
                    break;
                case 4: 
                    System.out.println("Adios"); 
                    break;
                default: 
                    System.out.println("Opcion invalida");
            }
        }
        while (opcion != 4);
    }
}