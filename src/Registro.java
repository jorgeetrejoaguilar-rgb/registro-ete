import java.util.Scanner;

class Registro
{
    private Scanner teclado;
    private AlumnoETE[] alumnos = new AlumnoETE[100];
    private int total = 0;

    // Catalogo: la posicion de cada ETE coincide en los 3 arreglos
    private String[] etes = {"Computacion", "Contabilidad",
                             "Ensenanza del ingles", "Hispatologia"};
    private String[][] gruposM = {{"61B", "61C"}, {"6211"}, {"6E1B"}, {}};
    private String[][] gruposV = {{"61A", "61D"}, {"6231"}, {"6E1A"}, {"8631"}};

    public Registro(Scanner t)
    {
        teclado = t;
    }

    private int leerInt()
    {
        return Integer.parseInt(teclado.nextLine());
    }

    public void registrar()
    {
        if (total >= 100)
        {
            System.out.println("Capacidad a full");
            return;
        }

        AlumnoETE a = new AlumnoETE();

        System.out.print("Numero de cuenta: ");
        a.asignaNocta(teclado.nextLine());
        System.out.print("Nombre: ");
        a.asignaNom(teclado.nextLine());
        System.out.print("Grupo curricular: ");
        a.asignaGrupo(teclado.nextLine());

        // ETE
        for (int i = 0; i < etes.length; i++)
            System.out.println((i + 1) + ". " + etes[i]);
        System.out.print("ETE: ");
        int e = leerInt() - 1;
        if (e < 0 || e >= etes.length)
        {
            System.out.println("ETE invalida");
            return;
        }
        a.asignaEte(etes[e]);

        // Turno
        System.out.print("Turno (1. Matutino  2. Vespertino): ");
        int t = leerInt();
        String[] grupos;
        if (t == 1)
        {
            grupos = gruposM[e];
            a.asignaTurno("Matutino");
        }
        else if (t == 2)
        {
            grupos = gruposV[e];
            a.asignaTurno("Vespertino");
        }
        else
        {
            System.out.println("Turno invalido");
            return;
        }
        if (grupos.length == 0)
        {
            System.out.println("Esa ETE no tiene grupos en ese turno");
            return;
        }

        // Grupo
        for (int i = 0; i < grupos.length; i++)
            System.out.println((i + 1) + ". " + grupos[i]);
        System.out.print("Grupo: ");
        int g = leerInt() - 1;
        if (g < 0 || g >= grupos.length)
        {
            System.out.println("Grupo invalido");
            return;
        }
        a.asignaGrupoEte(grupos[g]);

        // Solo se guarda si todo salio bien
        alumnos[total] = a;
        total++;
        System.out.println("Alumno registrado. Total: " + total);
    }

    public void capturarCalif()
    {
        System.out.println("Pendiente");
    }

    public void consultar()
    {
        System.out.println("Pendiente");
    }
}