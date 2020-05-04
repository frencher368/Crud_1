package Nomina;
/**
 * @author Alejandro Erazo
 */

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Main {
    
    private static final String ODB_NAME = "Nomina.neodatis";
    
    // ----------------------------------
    // Metodos
    // ----------------------------------

    private static void insertaDatos()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);

            Empleado p1 = new Empleado("Camilo", 1107519529, "Asesor Comercial", 350000);
            Empleado p2 = new Empleado("Alejandro", 1123457632, "Cajero", 360000);
            Empleado p3 = new Empleado("Juan David", 1154796321, "Veterinario", 520000);
            Empleado p4 = new Empleado("Luisa Maria", 1147256345, "Veterinario", 520000);
            Empleado p5 = new Empleado("Estefania", 221431562, "Veterinario", 520000);
            Empleado p6 = new Empleado("Laureano", 887523456, "Cajero", 360000);

            odb.store(p1);
            odb.store(p2);
            odb.store(p3);
            odb.store(p4);
            odb.store(p5);
            odb.store(p6);

        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }
    
    private static void cantidadDatos()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);
            Objects<Empleado> objects = odb.getObjects(Empleado.class);

            System.out.print("\n");
            System.out.println("Existen " + objects.size() + " Empleados registrados en la veterinaria.");
            System.out.print("\n");

            int i = 1;

            while(objects.hasNext())
            {
                Empleado actual = objects.next();
                System.out.println("[ " + i + " ] " + actual.getNombre() + " " + actual.getCargo());
                i++;
            }

        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }

    private static void ordenarPorNombre()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);

            
            System.out.print("\n");
            System.out.println("Lista de los empleados ordenada de manera ASC por el nombre.");
            System.out.print("\n");
            
            IQuery query = new CriteriaQuery( Empleado.class ).orderByAsc("nombre");
            Objects<Empleado> objects = odb.getObjects(query);

            int i = 1;
            while(objects.hasNext())
            {
                Empleado actual = objects.next();
                System.out.println("[ " + i + " ] " + actual.getNombre());
                i++;
            }

            System.out.print("\n");
            System.out.println("Lista de los empleados ordenada de manera DES por el nombre.");
            System.out.print("\n");

            query = new CriteriaQuery( Empleado.class ).orderByDesc("nombre");
            objects = odb.getObjects(query);


            i = 1;
            while(objects.hasNext())
            {
                Empleado actual = objects.next();
                System.out.println("[ " + i + " ] " + actual.getNombre());
                i++;
            }

        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }
    
    private static void filtraPorCargoCajero()
    {
        ODB odb = null;
        try {
            odb = ODBFactory.open(ODB_NAME);
            IQuery query = new CriteriaQuery(Empleado.class, Where.equal("cargo", "Cajero"));
            Objects<Empleado> objects = odb.getObjects(query);

            System.out.print("\n");
            System.out.println("Hay " + objects.size() + " con el cargo de Cajero");
            System.out.print("\n");

            int i = 1;
            while(objects.hasNext())
            {
                Empleado actual = objects.next();
                System.out.println("[ " + i + " ] " + actual.getNombre() + " " + actual.getCargo() + " " + actual.getSalario());
                i++;
            }

        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }
    
    private static void borrarBaseDatosActual()
    {
        Objects objects;

        // Open the database
        ODB odb = null;

        try {
            odb = ODBFactory.open(ODB_NAME);
            objects = odb.getObjects(Empleado.class);
            while (objects.hasNext()) {
                odb.delete(objects.next());
            }
        } finally {
            if (odb != null) {
                odb.close();
            }
        }
    }  
    
    // ----------------------------------
    // Ejecutar los metodos
    // ----------------------------------
    public static void main (String arg []) {
        
        Main inicio = new Main();
        inicio.filtraPorCargoCajero();
    }
}
