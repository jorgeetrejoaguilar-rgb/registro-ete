import java.util.Scanner;

class Main 
{
    public static void main(String args[]) 
    {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do 
        {
            System.out.println("\n--- REGISTRO ETE (AVANCE 1) ---");
            System.out.println("1. Registrar estudiante");
            System.out.println("2. Captura calificaciones (Pendiente)");
            System.out.println("3. Consulta de datos (Pendiente)");
            System.out.println("4. Salir");
            System.out.print("Opcion: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opcion) 
            {
                case 1:
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("");
                    break;

                default:
                    System.out.println("");
            }
        } 
        while (opcion != 4);
    }
}   