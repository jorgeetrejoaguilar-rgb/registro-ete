import java.util.Scanner;

class Registro
{
    private Scanner teclado;
    private AlumnoETE[] alumnos = new AlumnoETE[100];
    private int total = 0;

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

    private double leerCal()
    {
        double c;
        do
        {
            System.out.print("Calificacion (0-10): ");
            c = Double.parseDouble(teclado.nextLine());
        }
        while (c < 0 || c > 10);
        return c;
    }

    public void registrar()
    {
        if (total >= 100)
        {
            System.out.println("Capacidad llena");
            return;
        }

        AlumnoETE a = new AlumnoETE();

        System.out.print("Numero de cuenta: ");
        a.asignaNocta(teclado.nextLine());
        System.out.print("Nombre: ");
        a.asignaNom(teclado.nextLine());
        System.out.print("Grupo curricular: ");
        a.asignaGrupo(teclado.nextLine());

        for (int i = 0; i < etes.length; i++)
        {
            System.out.println((i + 1) + ". " + etes[i]);
        }
        System.out.print("ETE: ");
        int e = leerInt() - 1;
        if (e < 0 || e >= etes.length)
        {
            System.out.println("ETE invalida");
            return;
        }
        a.asignaEte(etes[e]);

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

        for (int i = 0; i < grupos.length; i++)
        {
            System.out.println((i + 1) + ". " + grupos[i]);
        }
        System.out.print("Grupo: ");
        int g = leerInt() - 1;
        if (g < 0 || g >= grupos.length)
        {
            System.out.println("Grupo invalido");
            return;
        }
        a.asignaGrupoEte(grupos[g]);

        alumnos[total] = a;
        total++;
        System.out.println("Alumno registrado con exito. Total: " + total);
    }

    public void capturarCalif()
    {
        System.out.println("1. Individual   2. Por grupo");
        System.out.print("Opcion: ");
        int op = leerInt();
        if (op == 1)
        {
            califIndividual();
        }
        else if (op == 2)
        {
            califGrupo();
        }
        else
        {
            System.out.println("Opcion invalida");
        }
    }

    private void califIndividual()
    {
        System.out.print("Numero de cuenta: ");
        int i = buscar(teclado.nextLine());
        if (i == -1)
        {
            System.out.println("No existe ese alumno");
            return;
        }

        System.out.println("1. Periodo 1  2. Periodo 2  3. Periodo 3  4. Todos");
        System.out.print("Opcion: ");
        int p = leerInt();
        if (p >= 1 && p <= 3)
        {
            System.out.print("Periodo " + p + " ");
            alumnos[i].asignaCal(p, leerCal());
        }
        else if (p == 4)
        {
            for (int k = 1; k <= 3; k++)
            {
                System.out.print("Periodo " + k + " ");
                alumnos[i].asignaCal(k, leerCal());
            }
        }
        else
        {
            System.out.println("Opcion invalida");
            return;
        }
        System.out.println("Promedio: " + alumnos[i].despPromedio());
    }

    private void califGrupo()
    {
        System.out.print("Grupo ETE: ");
        String g = teclado.nextLine();
        System.out.print("Periodo (1-3): ");
        int p = leerInt();
        if (p < 1 || p > 3)
        {
            System.out.println("Periodo invalido");
            return;
        }

        boolean hay = false;
        for (int i = 0; i < total; i++)
        {
            if (alumnos[i].despGrupoEte().equals(g))
            {
                hay = true;
                System.out.print(alumnos[i].despNom() + " ");
                alumnos[i].asignaCal(p, leerCal());
            }
        }
        if (!hay)
        {
            System.out.println("No hay alumnos en ese grupo");
        }
    }

    public void consultar()
    {
        Consulta c = new Consulta(teclado, alumnos, total);
        c.consultar();
    }
}