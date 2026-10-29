class Alumno 
{
    private String nocta;
    private String nom;
    private String grupo;

    public void asignaNocta(String n) 
    { 
        nocta = n; 
    }
    
    public void asignaNom(String n)   
    { 
        nom = n; 
    }
    
    public void asignaGrupo(String g) 
    { 
        grupo = g; 
    }

    public String despNocta() 
    { 
        return nocta; 
    }
    
    public String despNom()   
    { 
        return nom; 
    }
    
    public String despGrupo() 
    { 
        return grupo; 
    }
}