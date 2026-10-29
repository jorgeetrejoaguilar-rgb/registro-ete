class AlumnoETE extends Alumno 
{
    private String ete;
    private String turno;
    private String grupoEte;
    private double[] cal = new double[3];

    public void asignaEte(String e)      
    { 
        ete = e; 
    }
    
    public void asignaTurno(String t)    
    { 
        turno = t; 
    }
    
    public void asignaGrupoEte(String g) 
    { 
        grupoEte = g; 
    }

    public void asignaCal(int periodo, double valor) 
    {
        cal[periodo - 1] = valor;
    }

    public String despEte()      
    { 
        return ete; 
    }
    
    public String despTurno()    
    { 
        return turno; 
    }
    
    public String despGrupoEte() 
    { 
        return grupoEte; 
    }

    public double despCal(int periodo) 
    {
        return cal[periodo - 1];
    }

    public double despPromedio() 
    {
        return (cal[0] + cal[1] + cal[2]) / 3.0;
    }
}