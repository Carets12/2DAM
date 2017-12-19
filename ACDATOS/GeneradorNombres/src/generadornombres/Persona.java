/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadornombres;

/**
 *
 * @author Daniel Sierra
 */
public class Persona {

    private  String dni;
    private  String nombre;
    private  String apellidos;
    private  String sexo;
    
    private String[] nombreMasculino = {"Aarón", "Abdón", "Abelardo", "Abrahán", "Absalón", "Acacio", "Adalberto", "Adán", "Adolfo", "Adón", 
        "Adrián", "Agustín", "Aitor", "Albert", "Alberto","Alejandro", "Alfonso", "Alfredo", "Alipio", "Alonso","Álvaro", "Amadeo", 
        "Amaro", "Ambrosio", "Anatolio",  "Andrés","Ángel", "Aniano", "Anselmo", "Antero", "Antonio", "Aquiles", 
        "Arturo", "Baldomero", "Balduino", "Baltasar", "Bartolomé", "Benito", "Benjamín",  "Bernardo", "Blas", "Borja", "Bruno", "Casiano", 
        "Casimiro", "Casio","Cayetano", "Cayo", "Ceferino", "Cesáreo", "Cipriano", "Cirilo", "Donato", "Edgar","Edmundo",
        "Eduardo", "Efrén", "Elías", "Emiliano", "Emilio", "Enrique",  "Esiquio","Esteban", "Eugenio","Facundo", "Faustino", "Fausto", "Federico", "Feliciano", "Felipe", "Félix", "Fermín", "Fernando", 
        "Fortunato", "Francisco", "Fulgencio", "Germán","Godofredo", "Gonzalo","Gregorio", 
        "Guillermo", "Gustavo", "Guzmán", "Héctor", "Heliodoro", "Heraclio", "Heriberto", "Hilarión", "Homero", "Honorato","Honorio", 
        "Hugo", "Humberto", "Isaac","Jacinto", "Jacob", "Jacobo", "Jaime", "Jaume", "Javier", "Joaquín", "Joel", "Jonás", "Jonathan", "Jordi","Jorge", 
        "Leandro","Leonardo", "Luciano","Macario", "Marcelino", "Marcelo", "Marciano", "Marcos", "Mariano", "Martín", "Mateo", 
        "Matías", "Porfirio", "Primo", "Probo", "Rafael",  "Renato", "Ricardo", "Rigoberto", "Rubén", 
        "Rufo", "Ruperto", "Salomé", "Salomón", "Salvador", "Sebastián", "Segismundo", "Sergio", "Severino", "Tadeo", "Tarsicio", "Timoteo", "Tito", 
        "Tobías", "Tomas", "Tomás", "Toribio", "Valentín", "Valeriano", "Vicente", "Víctor", "Victorino", "Victorio", "Vidal", "Virgilio","Vladimiro", "Wilfredo", 
        "Xavier", "Zacarías", "Zaqueo"};
        
       private String[] nombresFemeninos = {"Adela", "Adelaida","Alba", "Albina", "Alejandra", "Alicia", "Almudena", "Amelia", "Amparo", "Ana", "Ananías", "Anastasia", 
        "Andrea", "Ángela", "Ángeles", "Anna", "Antonia", "Araceli","Ariadna", "Ascensión", "Asunción", "Áurea", "Aurelia",
        "Aurora", "Bárbara", "Begoña", "Belén","Bernarda", "Blanca",  "Cándida", "Carina",
        "Carolina", "Catalina","Cecilia", "Celia", "Celina", "Clara", "Claudia","Concepción", 
        "Cristina","Dimas", "Dolores","Elena", "Elisa", "Elvira", "Emilia", "Encarnación", "Epifanía","Esperanza", 
        "Ester", "Esther","Eulalia", "Eva", "Fabiola", "Fátima", "Francisca","Gema",
        "Gloria", "Guadalupe","Hildegarda", "Inmaculada", "Irene", "Isabel", "Josefa", "Josefina", "Juana", "Julia",
        "Laura",  "Lidia",  "Lorena","Lucrecia", "Luisa","Magdalena","Manuela", "Marina", "Marta","Matilde",
        "Míriam", "Mónica", "Montserrat","Nieves", "Noelia", "Nuria","Olga",
        "Otilia", "Patricia", "Paula", "Pilar","Rebeca","Rocío", "Rosa", "Rosalia", "Rosario", "Sandra","Sara", "Silvia", "Sofía", "Soledad",
        "Sonia", "Susana", "Teodora", "Teófila", "Teresa","Trinidad", "Úrsula",  "Vanesa", "Verónica", "Vicenta",  "Victoria", "Yolanda"};
        
        private String[] apellido = {"Aguilar","Alonso","Álvarez","Arias","Benítez","Blanco","Blesa","Bravo","Caballero",
        "Cabrera","Calvo","Cambil","Campos","Cano","Carmona","Carrasco","Castillo","Castro","Cortés","Crespo",
        "Cruz","Delgado","Díaz","Díez","Domínguez","Durán","Fernández","Ferrer","Flores","Fuentes","Gallardo",
        "Gallego","García","Garrido","Gil","Giménez","Gómez","González","Guerrero","Gutiérrez","Hernández","Herrera","Herrero",
        "Hidalgo","Ibáñez","Iglesias","Jiménez","León","López","Lorenzo","Lozano","Marín","Márquez","Martín","Martínez","Medina",
        "Méndez","Molina","Montero","Montoro","Mora","Morales","Moreno","Moya","Muñoz","Navarro","Nieto","Núñez","Ortega",
        "Ortiz","Parra","Pascual","Pastor","Peña","Pérez","Prieto","Ramírez","Ramos","Rey","Reyes","Rodríguez","Román","Romero",
        "Rubio","Ruiz","Sáez","Sánchez","Santana","Santiago","Santos","Sanz","Serrano","Soler","Soto","Suárez","Torres","Vargas",
        "Vázquez","Vega","Velasco","Vicente","Vidal"};
       
    public Persona() {
    }        
        
    public Persona(String dni, String nombre, String apellidos, String sexo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String[] getNombreMasculino() {
        return nombreMasculino;
    }

    public void setNombreMasculino(String[] nombreMasculino) {
        this.nombreMasculino = nombreMasculino;
    }

    public String[] getNombresFemeninos() {
        return nombresFemeninos;
    }

    public void setNombresFemeninos(String[] nombresFemeninos) {
        this.nombresFemeninos = nombresFemeninos;
    }

    public String[] getApellido() {
        return apellido;
    }

    public void setApellido(String[] apellido) {
        this.apellido = apellido;
    }
      
    @Override
    public String toString() {
        return "Persona:::: " + "dni: " + dni + ", nombre: " + nombre + ", apellidos: " + apellidos + ", sexo: " + sexo;
    }

    String getDni(Persona get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}