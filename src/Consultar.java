import java.util.Scanner;
class Consulta 
{
    private Scanner teclado;
    private AlumnoETE[] alumnos;
    private int total;

    public Consulta(Scanner t, AlumnoETE[] a, int tot) 
    {
        teclado = t;
        alumnos = a;
        total = tot;
    }

    private int buscar(String nocta) 
    {
        for (int i = 0; i < total; i++) 
        {
            if (alumnos[i].despNocta().equals(nocta)) 
            {
                return i;
            }
        }
        return -1;
    }

    public void consultar() 
    {
        System.out.println("1. Consulta Individual   2. Consulta por grupo");
        System.out.print("Opcion: ");
        int op = Integer.parseInt(teclado.nextLine());
        
        if (op == 1) 
        {
            consultaIndividual();
        } 
        else if (op == 2) 
        {
            consultaGrupo();
        } 
        else 
        {
            System.out.println("Opcion invalida");
        }
    }

    private void consultaIndividual() 
    {
        System.out.print("Numero de cuenta: ");
        int i = buscar(teclado.nextLine());
        if (i == -1) 
        {
            System.out.println("No existe ese alumno");
            return;
        }

        System.out.println("\n--- DATOS DEL ALUMNO ---");
        System.out.println("Numero de cuenta: " + alumnos[i].despNocta());
        System.out.println("Nombre: " + alumnos[i].despNom());
        System.out.println("Grupo curricular: " + alumnos[i].despGrupo());
        System.out.println("Estudio tecnico: " + alumnos[i].despEte());
        System.out.println("Turno: " + alumnos[i].despTurno());
        System.out.println("Grupo ETE: " + alumnos[i].despGrupoEte());
        
        System.out.println("Calificaciones:");
        System.out.println("Periodo 1: " + alumnos[i].despCal(1));
        System.out.println("Periodo 2: " + alumnos[i].despCal(2));
        System.out.println("Periodo 3: " + alumnos[i].despCal(3));
        System.out.println("Promedio final: " + alumnos[i].despPromedio());
    }

    private void consultaGrupo() 
    {
        System.out.print("Grupo ETE: ");
        String g = teclado.nextLine();
        boolean hay = false;

        System.out.println("\n--- ALUMNOS DEL GRUPO " + g + " ---");
        for (int i = 0; i < total; i++) 
        {
            if (alumnos[i].despGrupoEte().equals(g)) 
            {
                hay = true;
                System.out.println("-----------------------------");
                System.out.println("Nocta: " + alumnos[i].despNocta());
                System.out.println("Nombre: " + alumnos[i].despNom());
                System.out.println("Califs: " + alumnos[i].despCal(1) + " | " + alumnos[i].despCal(2) + " | " + alumnos[i].despCal(3));
                System.out.println("Promedio: " + alumnos[i].despPromedio());
            }
        }
        if (!hay) 
        {
            System.out.println("No hay alumnos registrados en ese grupo");
        }
    }
}
