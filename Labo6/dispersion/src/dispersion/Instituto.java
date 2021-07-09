package dispersion;

public class Instituto {

    public Alumno alumnos[];
    private final int TAM_TABLA = 20;
    private Alumno anid[][];

    public Instituto() {
        alumnos = new Alumno[TAM_TABLA];
        for (int i = 0; i < TAM_TABLA; i++) {
            alumnos[i] = new Alumno("0", "", 0);
        }

        anid = new Alumno[TAM_TABLA][TAM_TABLA];
        for (int i = 0; i < TAM_TABLA; i++) {
            for (int j = 0; j < TAM_TABLA; j++) {
                anid[i][j] = new Alumno("0", "", 0);
            }
        }
    }

    public void setCodigoDelAlumno(String codigo, int i) {
        alumnos[i].setCodigoDelAlumno(codigo);
    }

    public String getCodigoDelAlumno(int i) {
        return alumnos[i].getCodigoDelAlumno();
    }

    public void setNombreDelAlumno(String nombre, int i) {
        alumnos[i].setNombreDelAlumno(nombre);
    }

    public String getNombreDelAlumno(int i) {
        return alumnos[i].getNombreDelAlumno();
    }

    public void setPensionDelAlumno(float pension, int i) {
        alumnos[i].setPensionDelAlumno(pension);
    }

    public float getPensionDelAlumno(int i) {
        return alumnos[i].getPensionDelAlumno();
    }

    public int getNumeroDeAlumnos() {
        return TAM_TABLA;
    }

    public int hash(String  clave) {
        int s = 0;
        for (int i = 0; i < clave.length(); i++) {
            s += (int) clave.charAt(i);
        }
        return s % 19;
    }

    public int hash2(int clave) {
        return clave + 2 % 19;
        
    }


    public void setCodigoDelAlumno(String codigo, int i, int j) {
        anid[i][j].setCodigoDelAlumno(codigo);
    }

    public String getCodigoDelAlumno(int i, int j) {
        return anid[i][j].getCodigoDelAlumno();
    }

    public void setNombreDelAlumno(String nombre, int i, int j) {
        anid[i][j].setNombreDelAlumno(nombre);
    }

    public String getNombreDelAlumno(int i, int j) {
        return anid[i][j].getNombreDelAlumno();
    }

    public void setPensionDelAlumno(float pension, int i, int j) {
        anid[i][j].setPensionDelAlumno(pension);
    }

    public float getPensionDelAlumno(int i, int j) {
        return anid[i][j].getPensionDelAlumno();
    }
//

    public boolean Insertar(String codigo, String nombre, float pension) {
        int pos, pos_sigte;
        pos = hash(codigo);
        if (Integer.parseInt(getCodigoDelAlumno(pos)) == 0) {
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);
            return true;
        } else 
        {
            pos_sigte = pos + 1;
            while (pos_sigte < getNumeroDeAlumnos()
                    && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0
                    && pos_sigte != pos) {
                pos_sigte++;
                if (pos_sigte == getNumeroDeAlumnos()) {
                    setNombreDelAlumno(nombre, pos_sigte);
                    pos_sigte = 0;
                }
            }
            if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0) {
                setCodigoDelAlumno(codigo, pos_sigte);
                setNombreDelAlumno(nombre, pos_sigte);
                setPensionDelAlumno(pension, pos_sigte);

                return true;
            } else {
                return false;
            }
        }
    }

    public int Eliminar_PruebaLineal(String codigo) {
        int pos, pos_sigte;
        pos = hash(codigo);

        if (getCodigoDelAlumno(pos).compareTo(codigo) == 0) {
            setCodigoDelAlumno("0 ", pos);
            setNombreDelAlumno(" ", pos);
            setPensionDelAlumno(0, pos);

            return pos;
        } else    
        {
            pos_sigte = pos + 1;
            while (pos_sigte < getNumeroDeAlumnos()
                    && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0
                    && pos_sigte != pos
                    && getCodigoDelAlumno(pos_sigte).compareTo(codigo) != 0) {
                pos_sigte++;
                if (pos_sigte == getNumeroDeAlumnos()) {
                    pos_sigte = 0;
                }
            }
            if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0 || pos_sigte == pos) {
                return -1;   
            } else {
                setCodigoDelAlumno("0", pos_sigte);
                setNombreDelAlumno(" ", pos_sigte);
                setPensionDelAlumno(0, pos_sigte);
                return pos_sigte;
            }
        }
    }

    public boolean Insertar_PruebaCuadratica(String codigo, String nombre, float pension) {
        int pos, pos_sigte;
        pos = hash(codigo);
       System.out.println(codigo);
        if (Integer.parseInt(getCodigoDelAlumno(pos)) == 0) {
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);

            return true;
        } else 
        {
            int i = 1;
            pos_sigte = pos + i * i;

            while (pos_sigte < getNumeroDeAlumnos()
                    && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0
                    && pos_sigte != pos) {
                System.out.println(pos_sigte);
                i++;
                pos_sigte = pos + i * i;
                if (pos_sigte > getNumeroDeAlumnos() - 1) {
                    int pos_sigte_aux = i * i % pos;
                    pos_sigte = 0;
                    while (pos_sigte < getNumeroDeAlumnos()
                            && pos_sigte != pos
                            && getCodigoDelAlumno(pos_sigte).compareTo(codigo) != 0) {
                        pos_sigte = pos_sigte + pos_sigte_aux;
                    }
                }
            }

            if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0) {
                setCodigoDelAlumno(codigo, pos_sigte);
                setNombreDelAlumno(nombre, pos_sigte);
                setPensionDelAlumno(pension, pos_sigte);

                return true;
            } else {
                return false;
            }
        }
    }

    public int Busqueda_PruebaCuadratica(String codigo) {
        int pos, pos_sigte, i;
        pos = hash(codigo);
        if (getCodigoDelAlumno(pos).compareTo(codigo) == 0) {
            return pos;
        } else {
            i = 1;
            pos_sigte = pos + i * i;
            while (pos_sigte < getNumeroDeAlumnos()
                    && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0
                    && pos_sigte != pos
                    && getCodigoDelAlumno(pos_sigte).compareTo(codigo) != 0) {
                i++;
                pos_sigte = pos + i * i;
                if (pos_sigte > getNumeroDeAlumnos() - 1) {
                    pos_sigte = 0;
                    while (pos_sigte < getNumeroDeAlumnos()
                            && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0
                            && pos_sigte != pos
                            && getCodigoDelAlumno(pos_sigte).compareTo(codigo) != 0) {
                        pos_sigte = pos + 1;
                    }
                }

            }

        }
        if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0 || pos_sigte == pos) {
            return -1; 
        } else {
            return pos_sigte;
        }

    }

    public boolean Eliminar_PruebaCuadratica(String codigo) {
        int pos, pos_sigte;
        pos = hash(codigo);
        if (getCodigoDelAlumno(pos).compareTo(codigo) == 0) {
            setCodigoDelAlumno("0 ", pos);
            setNombreDelAlumno(" ", pos);
            setPensionDelAlumno(0, pos);

            return true; 
        } else   
        {
            int i = 1;
            pos_sigte = pos + i * i;
            while (pos_sigte < getNumeroDeAlumnos() 
                    && pos_sigte != pos 
                    && getCodigoDelAlumno(pos).compareTo(codigo) != 0) {
                i++;
                pos_sigte = pos + i * i;
                if (pos_sigte > getNumeroDeAlumnos() - 1) {
                    int pos_sigte_aux = i * i % pos;
                    pos_sigte = 0;
                    while (pos_sigte < getNumeroDeAlumnos() 
                            && pos_sigte != pos 
                            && getCodigoDelAlumno(pos).compareTo(codigo) != 0) {
                        pos_sigte = pos_sigte + pos_sigte_aux;
                    }
                }
            }
            if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0 || pos_sigte == pos) {
                return false;   
            } else {
                setCodigoDelAlumno("0", pos_sigte);
                setNombreDelAlumno(" ", pos_sigte);
                setPensionDelAlumno(0, pos_sigte);
                return true; 
            }
        }
    }

    public boolean Insertar_DobleDireccion(String codigo, String nombre, float pension) {
        int pos, pos_sigte;
        pos = hash(codigo);
        if (Integer.parseInt(getCodigoDelAlumno(pos)) == 0) {
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);

            return true;
        } else   
        {
            pos_sigte = hash2(pos);
            while (pos_sigte < getNumeroDeAlumnos() - 1 
                    && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0 
                    && pos_sigte != pos) {
                pos_sigte = hash2(pos_sigte);
            }
            if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0) {
                setCodigoDelAlumno(codigo, pos);
                setNombreDelAlumno(nombre, pos);
                setPensionDelAlumno(pension, pos);
                return true;
            } else {
                return false;
            }
        }
    }
    
    public int Busqueda_DobleDirección(String codigo) {
        int pos, pos_sigte;
        pos = hash(codigo);
        if (getCodigoDelAlumno(pos).compareTo(codigo) == 0) {
            return pos;
        } else
        {
            pos_sigte = hash2(pos);
            while (pos_sigte < getNumeroDeAlumnos()
                    && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0
                    && pos_sigte != pos
                    && getCodigoDelAlumno(pos_sigte).compareTo(codigo) != 0) {
                pos_sigte = hash2(pos_sigte);
            }

        }
        if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0 || pos_sigte == pos) {
            return -1; 
        } else {
            return pos_sigte;
        }

    }

    public boolean Eliminar_DobleDireccion(String codigo) {
        int pos, pos_sigte;
        pos = hash(codigo);
        if (getCodigoDelAlumno(pos).compareTo(codigo) == 0) {
            setCodigoDelAlumno("0", pos);
            setNombreDelAlumno(" ", pos);
            setPensionDelAlumno(0, pos);

            return true;
        } else     
        {
            pos_sigte = hash2(pos);
            while (pos_sigte < getNumeroDeAlumnos() - 1 
                    && Integer.parseInt(getCodigoDelAlumno(pos_sigte)) != 0 
                    && getCodigoDelAlumno(pos_sigte).compareTo(codigo) != 0
                    && pos_sigte != pos) {
                pos_sigte = hash2(pos_sigte);
            }
            if (Integer.parseInt(getCodigoDelAlumno(pos_sigte)) == 0 || pos_sigte == pos) {
                return false;  
            } else {
                setCodigoDelAlumno("0", pos_sigte);
                setNombreDelAlumno(" ", pos_sigte);
                setPensionDelAlumno(0, pos_sigte);
                return true;
            }
        }
    }

    public boolean Insertar_ArreglosAnidados(String codigo, String nombre, float pension) {
        int pos, pos_sigte = 0;
        pos = hash(codigo);
        if (Integer.parseInt(getCodigoDelAlumno(pos, pos_sigte)) == 0) {
            setCodigoDelAlumno(codigo, pos, pos_sigte);
            setNombreDelAlumno(nombre, pos, pos_sigte);
            setPensionDelAlumno(pension, pos, pos_sigte);
            return true;
        } else {
            while (Integer.parseInt(getCodigoDelAlumno(pos, pos_sigte)) != 0 
                && pos_sigte < getNumeroDeAlumnos()) {
                pos_sigte++;
            }
            if (pos_sigte >= getNumeroDeAlumnos()) {
                return false;
            } else {
                setCodigoDelAlumno(codigo, pos, pos_sigte);
                setNombreDelAlumno(nombre, pos, pos_sigte);
                setPensionDelAlumno(pension, pos, pos_sigte);
                return true;
            }

        }
    }

    public int[] Buscar_ArreglosAnidados(String codigo) {
        int pos, pos_sigte = 0;
        int aux[] = new int[2];
        pos = hash(codigo);
        if (getCodigoDelAlumno(pos,pos_sigte).compareTo(codigo) == 0) {

            aux[0] = pos;
            aux[1] = pos_sigte;
            return aux;
        } else {
            for (int i = pos_sigte; i < getNumeroDeAlumnos(); i++) {

                if (getCodigoDelAlumno(pos,i).compareTo(codigo) == 0) {
                    aux[0] = pos;
                    aux[1] = i;
                    return aux;
                }
                if (getCodigoDelAlumno(pos,pos_sigte).compareTo(codigo) == 0) {
                    break;
                }
            }
        }
        aux[0] = -1;
        aux[1] = -1;
        return aux;
    }

    public boolean Eliminar_ArregloAnidado(String codigo) {
        int pos, pos_sigte = 0;
        pos = hash(codigo);
        if (getCodigoDelAlumno(pos,pos_sigte).compareTo(codigo) == 0) {
            setCodigoDelAlumno("0", pos, pos_sigte);
            setNombreDelAlumno("", pos, pos_sigte);
            setPensionDelAlumno(0, pos, pos_sigte);
            return true;
        } else {
            for (int i = pos_sigte; i < getNumeroDeAlumnos(); i++) {
                if (getCodigoDelAlumno(pos,pos_sigte).compareTo(codigo) == 0) {
                    setCodigoDelAlumno("0", pos, i);
                    setNombreDelAlumno("", pos, i);
                    setPensionDelAlumno(0, pos, i);
                    return true;
                }
                if (getCodigoDelAlumno(pos,pos_sigte).compareTo(codigo) == 0) {
                    break;
                }
            }
        }
        return false;
    }

    public boolean Insertar_Encadenamiento(String codigo, String nombre, float pension) {
        int pos;
        pos = hash(codigo);
        if (Integer.parseInt(getCodigoDelAlumno(pos)) == 0) {
            setCodigoDelAlumno(codigo, pos);
            setNombreDelAlumno(nombre, pos);
            setPensionDelAlumno(pension, pos);

            return true;
        } else  
        {

            while (alumnos[pos].siguiente != null) {

                alumnos[pos].siguiente = alumnos[pos].siguiente.siguiente;
            }
            alumnos[pos].siguiente = new Alumno("0", "", 0);
            alumnos[pos].siguiente.setCodigoDelAlumno(codigo);
            alumnos[pos].siguiente.setNombreDelAlumno(nombre);
            alumnos[pos].siguiente.setPensionDelAlumno(pension);

            return true;

        }
    }


    public int Buscar_Encadenamiento(String codigo) {
        int pos;
        pos = hash(codigo);
        if (Integer.parseInt(getCodigoDelAlumno(pos)) == 0) {
            return pos;
        } else {
            while (alumnos[pos].siguiente != null) {

                if (alumnos[pos].siguiente.getCodigoDelAlumno().compareTo(codigo) == 0) {
                    System.out.println("encontardo en,pos");
                    return pos;
                } else {
                    alumnos[pos].siguiente = alumnos[pos].siguiente.siguiente;
                    return pos;
                }
            }
            return -1;

        }

    }

    public int Eliminar_Encadenamiento(String codigo) {
        int pos;
        pos = hash(codigo);
        if (Integer.parseInt(getCodigoDelAlumno(pos)) == 0) {
            alumnos[pos].setCodigoDelAlumno("0");
            alumnos[pos].setNombreDelAlumno(" ");
            alumnos[pos].setPensionDelAlumno(0);
            return pos;
        } else {
            while (alumnos[pos].siguiente != null) {
                if (alumnos[pos].siguiente.getCodigoDelAlumno().compareTo(codigo) == 0) {

                    alumnos[pos].siguiente.setCodigoDelAlumno("0");
                    alumnos[pos].siguiente.setNombreDelAlumno(" ");
                    alumnos[pos].siguiente.setPensionDelAlumno(0);
                } else {
                    alumnos[pos].siguiente = alumnos[pos].siguiente.siguiente;
                }
            }
            return -1; 
        }
      
    }
}
