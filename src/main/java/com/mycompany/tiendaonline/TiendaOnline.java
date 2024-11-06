package com.mycompany.tiendaonline;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiendaOnline {
    
    //listas
    private static List<Articulo> Articulos = new ArrayList<>();
    private static List<Usuario> Usuarios = new ArrayList<>();
    private static List<Factura> histco = new ArrayList<>();
    
    public static void Registrar_usuario(){
        Scanner scanner = new Scanner(System.in);
        Usuario usuario1 = new Usuario();
        System.out.println("Ingrese su nombre: ");
        usuario1.setNombre(scanner.nextLine());
        System.out.println("Ingrese su apellido: ");
        usuario1.setApellido(scanner.nextLine());
        System.out.println("Ingrese numero de identificacion: ");
        usuario1.setid(scanner.nextLine());
        System.out.println("Ingrese numero de telefono: ");
        usuario1.setTelefono(scanner.nextLine());
        System.out.println("Ingrese su direccion: ");
        usuario1.setDireccion(scanner.nextLine());
        System.out.println("Ingrese la contraseña: ");
        usuario1.setContrasena(scanner.nextLine());
        System.out.println("Ingrese su correo electronico: ");
        usuario1.setCorreo(scanner.nextLine());
        System.out.println("El usuario ha sido creado con exito");
        Usuarios.add(usuario1);
    }
    
    public static Usuario Iniciar_sesion(List<Usuario> Usuarios){
        Scanner scanner = new Scanner(System.in);
        int salir;
        do{
            System.out.println("Bienvenido al inicio de sesión\n0: salir | 1: continuar");
            salir = scanner.nextInt();
            switch(salir){
                case 0:
                    break;
                case 1:
                    System.out.println("Ingrese el correo: ");
                    scanner.nextLine();
                    String correo = scanner.nextLine();
                    System.out.println("Ingrese la contraseña: ");
                    String contrasena = scanner.nextLine();
                    
                    if(Usuarios.isEmpty()){
                        System.out.println("Esta cuenta no esta registrada.");
                    }
                    else{
                        for (Usuario usuario1 : Usuarios){
                            if (usuario1 != null && usuario1.getCorreo().equalsIgnoreCase(correo) && usuario1.getContrasena().equals(contrasena)){
                                System.out.println("Se ha iniciado sesion con exito!!");
                                return usuario1;
                            }
                        }
                        System.out.println("Has ingresado los datos incorrectos.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while(salir != 0);
    return null;
}
    public static void main(String[] args) {
        
        //base de datos
        Articulo articulo1 = new Articulo();
        articulo1.Crear_Articulo(1, "Figura de acción Super Mario",94000, "Coleccionable", 2);
        Articulo articulo2 = new Articulo();
        articulo2.Crear_Articulo(2, "Insignia Goku", 10000, "Coleccionable", 1);
        Articulo articulo3 = new Articulo();
        articulo3.Crear_Articulo(3, "Llavero Kirby Star Race", 23500, "Coleccionable", 1);
        Articulo articulo4 = new Articulo();
        articulo4.Crear_Articulo(4, "Poster Tsurupeta", 45000, "Colgable", 7);

        Articulos.add(articulo1);
        Articulos.add(articulo2);
        Articulos.add(articulo3);
        Articulos.add(articulo4);
        
        Usuario usuario1 = new Usuario();
        usuario1.Crear_Usuario("pedro", "picapiedra", "1", "123", "laRoca", "1", "yalitaz@gmail.com");
        
        Usuario usuario2 = new Usuario();
        usuario2.Crear_Usuario("samuel", "jaramillo", "2", "1234", "laRoca2", "1", "1");
        Usuarios.add(usuario1);
        Usuarios.add(usuario2);
        //
        Scanner scanner = new Scanner(System.in);
        int opcion, opcion2, opcion3, opcion4, opcion5;
        Usuario inicio_sesion;
        inicio_sesion = null;
        
        do{
            
            System.out.println("---------Tienda Online-----------");
            System.out.println("1. Articulos");
            System.out.println("2. Carrito de compras");
            System.out.println("3. Pedido personalizado");
            System.out.println("4. Iniciar sesion");
            System.out.println("5. Cerrar sesion");
            System.out.println("6. Registrarse");
            System.out.println("7. Cuenta");
            System.out.println("0. Salir");
            System.out.println("---------------------------------");
            System.out.println();
            System.out.println("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    //Articulos();
                    for(Articulo Articulo1 : Articulos){
                        System.out.println(Articulo1.getId() + " - " + Articulo1.getNombre());
                    }
                    System.out.println("\nSeleccione un artículo: ");
                    opcion3 = scanner.nextInt();
                    if (opcion3 < 1 || opcion3 > Articulos.size()){
                        System.out.println("Opción no válida.\n");
                    }
                    else{
                        Articulos.get(opcion3 - 1).MostrarArticulo();
                        System.out.println("Agregar al carrito? \n0: No | 1: Si");
                        opcion2 = scanner.nextInt();
                        switch(opcion2){
                            case 0:
                                break;
                            case 1:
                                if (inicio_sesion != null){
                                    int cantidad, cantidadA, flag;
                                    flag = 0;
                                    System.out.println("Cuántos agregar: ");
                                    cantidad = scanner.nextInt();
                                    if((cantidad > 0 && inicio_sesion.getCarrito_compras().getListaArticulos().isEmpty()) || cantidad > 0 && (cantidad + inicio_sesion.getCarrito_compras().Buscar_articulo_por_nombre(Articulos.get(opcion3 - 1).getNombre()).getCantidad()) <= Articulos.get(opcion3 - 1).getCantidad()){
                                        cantidadA = Articulos.get(opcion3 - 1).getCantidad();
                                        if (cantidadA < cantidad){
                                            System.out.println("No hay stock, por favor ingresa una cantidad mas pequeña.");
                                        }
                                        else{
                                            for(Articulo articulo: inicio_sesion.getCarrito_compras().getListaArticulos()){
                                                if (articulo.getNombre().equalsIgnoreCase(Articulos.get(opcion3 - 1).getNombre())){
                                                    articulo.setCantidad(articulo.getCantidad() + cantidad);
                                                    flag=1;
                                                    break;
                                                }
                                            }
                                            if (flag == 0){
                                                Articulo articulox = new Articulo();
                                                articulox.Crear_Articulo(Articulos.get(opcion3 - 1).getId(), Articulos.get(opcion3 - 1).getNombre(), Articulos.get(opcion3 - 1).getPrecio(), Articulos.get(opcion3 - 1).getClasificacion(), cantidad);
                                                inicio_sesion.getCarrito_compras().agregarProducto(articulox);
                                            }
                                        }
                                    }
                                    else{
                                        System.out.println("Cantidad no válida. O no hay stock.");
                                        break;
                                    }
                                }
                                else{
                                    System.out.println("Inicie sesion primero para agregar artículos a su carrito de compras.");
                                }
                                break;
                        }
                    }
                    break;
                case 2:
                    if (inicio_sesion != null){
                        if (inicio_sesion.getCarrito_compras().getListaArticulos().isEmpty() && inicio_sesion.getCarrito_compras().getListaP().isEmpty()){
                            System.out.println("El carrito está vacío.");
                        }
                        else{
                            double total = inicio_sesion.getCarrito_compras().calcularTotal();
                            int i = 1;
                            inicio_sesion.getCarrito_compras().Mostrar_articulos();
                            System.out.println("El total es de: $" + total + "\n");
                            System.out.println("0: Salir | 1: Quitar artículos | 2: Vaciar el carrito | 3: Pagar");
                            opcion2 = scanner.nextInt();
                            switch(opcion2){
                                case 0:
                                    break;
                                case 1:
                                    System.out.println("Seleccionar artículo: ");
                                    opcion3 = scanner.nextInt();
                                    if (opcion3 < 1 || opcion3 > inicio_sesion.getCarrito_compras().getListaArticulos().size() + inicio_sesion.getCarrito_compras().getListaP().size()){
                                        System.out.println("Opción no válida.");
                                    }
                                    else{
                                        System.out.println("0: Cancelar | 1: Quitar cantidad | 2: Quitar artículo");
                                        opcion4 = scanner.nextInt();
                                        scanner.nextLine();
                                        switch(opcion4){
                                            case 0:
                                                break;
                                            case 1:
                                                System.out.println("Cuántos desea quitar: ");
                                                int cantidad = scanner.nextInt();
                                                if (cantidad < 1 || (inicio_sesion.getCarrito_compras().getListaArticulos().isEmpty() != true) && (cantidad > inicio_sesion.getCarrito_compras().getListaArticulos().get(opcion3 - 1).getCantidad()) || (inicio_sesion.getCarrito_compras().getListaP().isEmpty() != true) && (cantidad > inicio_sesion.getCarrito_compras().getListaP().get(opcion3 - 1).getCantidad())){
                                                    System.out.println("Cantidad no válida.");
                                                }
                                                else{       
                                                        if (opcion3  > inicio_sesion.getCarrito_compras().getListaArticulos().size()){
                                                            int eleccion = opcion3 - 1 - inicio_sesion.getCarrito_compras().getListaArticulos().size();
                                                            inicio_sesion.getCarrito_compras().getListaP().get(eleccion).setCantidad(inicio_sesion.getCarrito_compras().getListaP().get(eleccion).getCantidad() - cantidad);
                                                            if (inicio_sesion.getCarrito_compras().getListaP().get(eleccion).getCantidad() == 0){
                                                                inicio_sesion.getCarrito_compras().getListaP().remove(eleccion);
                                                            }
                                                        }
                                                        else{
                                                            inicio_sesion.getCarrito_compras().getListaArticulos().get(opcion3 - 1).setCantidad(inicio_sesion.getCarrito_compras().getListaArticulos().get(opcion3 - 1).getCantidad() - cantidad);
                                                            if (inicio_sesion.getCarrito_compras().getListaArticulos().get(opcion3 - 1).getCantidad() == 0){
                                                                inicio_sesion.getCarrito_compras().getListaArticulos().remove(opcion3 - 1);
                                                            }
                                                        }
                                                    }
                                                break;
                                            case 2:
                                                if (opcion3 > inicio_sesion.getCarrito_compras().getListaArticulos().size()){
                                                            int eleccion = opcion3 - 1 - inicio_sesion.getCarrito_compras().getListaArticulos().size();
                                                            inicio_sesion.getCarrito_compras().getListaP().remove(eleccion);
                                                        }
                                                        else{
                                                            inicio_sesion.getCarrito_compras().getListaArticulos().remove(opcion3 - 1);
                                                        }
                                                break;
                                            default:
                                                System.out.println("Opción no válida.");
                                                break;
                                        }
                                    }
                                    break;
                                case 2:
                                    inicio_sesion.getCarrito_compras().getListaP().clear();
                                    inicio_sesion.getCarrito_compras().getListaArticulos().clear();
                                    break;
                                case 3:
                                    //pagar
                                    System.out.println("Seleccionar forma de pago 1: Paypal | 2: Tarjeta de Crédito | 3: Tarjeta de Débito | 4: Cuenta bancaria | 0: Cancelar.");
                                    opcion4 = scanner.nextInt();
                                    scanner.nextLine();
                                    switch(opcion4){
                                        case 0:
                                            break;
                                        case 1:
                                            if (inicio_sesion.getForma_de_pago().PaypalExiste()){
                                                if(inicio_sesion.getForma_de_pago().getPaypal().getSaldo() >= inicio_sesion.getCarrito_compras().calcularTotal()){
                                                    for(Articulo articulo: inicio_sesion.getCarrito_compras().getListaArticulos()){
                                                        for(Articulo articulox: Articulos){
                                                            if(articulo.getNombre().equalsIgnoreCase(articulox.getNombre())){
                                                                articulox.setCantidad(articulox.getCantidad() - articulo.getCantidad());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    inicio_sesion.getForma_de_pago().getPaypal().setSaldo(inicio_sesion.getForma_de_pago().getPaypal().getSaldo() - inicio_sesion.getCarrito_compras().calcularTotal());
                                                    Factura factura = new Factura(inicio_sesion.getid(), inicio_sesion.getCarrito_compras(), "Marzo", inicio_sesion.getCarrito_compras().calcularTotal(), "Paypal", "l");
                                                    inicio_sesion.gethistorial_compras().add(factura);
                                                    System.out.println("________________________________________________");
                                                    System.out.println("Id factura: \n" + inicio_sesion.getid() + "\nLista Articulos: ");
                                                    inicio_sesion.getCarrito_compras().Mostrar_articulos();
                                                    System.out.println("\nFecha: " + "date" + "\nTotal pagado: " + inicio_sesion.getCarrito_compras().calcularTotal() + "\nForma de pago: " + "paypal" + "\nDestino: " + inicio_sesion.getDireccion());
                                                    System.out.println("________________________________________________");
                                                    inicio_sesion.getCarrito_compras().getListaArticulos().clear();
                                                    System.out.println("Gracias por tu compra!!");
                                                }
                                                else{
                                                    System.out.println("No tienes saldo suficiente.");
                                                }
                                            }
                                            else{
                                                System.out.println("No tienes un Paypal enlazado a tu cuenta.");
                                            }
                                            break;
                                        case 2:
                                            if (inicio_sesion.getForma_de_pago().CreditoExiste()){
                                                if(inicio_sesion.getForma_de_pago().getCredito().getSaldo() >= inicio_sesion.getCarrito_compras().calcularTotal()){
                                                    for(Articulo articulo: inicio_sesion.getCarrito_compras().getListaArticulos()){
                                                        for(Articulo articulox: Articulos){
                                                            if(articulo.getNombre().equalsIgnoreCase(articulox.getNombre())){
                                                                articulox.setCantidad(articulox.getCantidad() - articulo.getCantidad());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    inicio_sesion.getForma_de_pago().getCredito().setSaldo(inicio_sesion.getForma_de_pago().getCredito().getSaldo() - inicio_sesion.getCarrito_compras().calcularTotal());
                                                    Factura factura = new Factura(inicio_sesion.getid(), inicio_sesion.getCarrito_compras(), "Marzo", inicio_sesion.getCarrito_compras().calcularTotal(), "Paypal", "l");
                                                    inicio_sesion.gethistorial_compras().add(factura);
                                                    System.out.println("________________________________________________");
                                                    System.out.println("Id factura: \n" + inicio_sesion.getid() + "\nLista Articulos: ");
                                                    inicio_sesion.getCarrito_compras().Mostrar_articulos();
                                                    System.out.println("\nFecha: " + "date" + "\nTotal pagado: " + inicio_sesion.getCarrito_compras().calcularTotal() + "\nForma de pago: " + "credito" + "\nDestino: " + inicio_sesion.getDireccion());
                                                    System.out.println("________________________________________________");
                                                    inicio_sesion.getCarrito_compras().getListaArticulos().clear();
                                                    System.out.println("Gracias por tu compra!!");
                                                }
                                                else{
                                                    System.out.println("No tienes saldo suficiente.");
                                                }
                                            }
                                            else{
                                                System.out.println("No tienes una tarjeta de Crédito enlazada a tu cuenta.");
                                            }
                                            break;
                                        case 3:
                                            if (inicio_sesion.getForma_de_pago().DebitoExiste()){
                                                if(inicio_sesion.getForma_de_pago().getDebito().getSaldo() >= inicio_sesion.getCarrito_compras().calcularTotal()){
                                                    for(Articulo articulo: inicio_sesion.getCarrito_compras().getListaArticulos()){
                                                        for(Articulo articulox: Articulos){
                                                            if(articulo.getNombre().equalsIgnoreCase(articulox.getNombre())){
                                                                articulox.setCantidad(articulox.getCantidad() - articulo.getCantidad());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    inicio_sesion.getForma_de_pago().getDebito().setSaldo(inicio_sesion.getForma_de_pago().getDebito().getSaldo() - inicio_sesion.getCarrito_compras().calcularTotal());
                                                    Factura factura = new Factura(inicio_sesion.getid(), inicio_sesion.getCarrito_compras(), "Marzo", inicio_sesion.getCarrito_compras().calcularTotal(), "Paypal", "l");
                                                    inicio_sesion.gethistorial_compras().add(factura);
                                                    System.out.println("________________________________________________");
                                                    System.out.println("Id factura: \n" + inicio_sesion.getid() + "\nLista Articulos: ");
                                                    inicio_sesion.getCarrito_compras().Mostrar_articulos();
                                                    System.out.println("\nFecha: " + "date" + "\nTotal pagado: " + inicio_sesion.getCarrito_compras().calcularTotal() + "\nForma de pago: " + "debito" + "\nDestino: " + inicio_sesion.getDireccion());
                                                    System.out.println("________________________________________________");
                                                    inicio_sesion.getCarrito_compras().getListaArticulos().clear();
                                                    System.out.println("Gracias por tu compra!!");
                                                }
                                                else{
                                                    System.out.println("No tienes saldo suficiente.");
                                                }
                                            }
                                            else{
                                                System.out.println("No tienes una tarjeta de Débito enlazada a tu cuenta.");
                                            }
                                            break;
                                        case 4:
                                            if (inicio_sesion.getForma_de_pago().BancoExiste()){
                                                if(inicio_sesion.getForma_de_pago().getBanco().getSaldo() >= inicio_sesion.getCarrito_compras().calcularTotal()){
                                                    for(Articulo articulo: inicio_sesion.getCarrito_compras().getListaArticulos()){
                                                        for(Articulo articulox: Articulos){
                                                            if(articulo.getNombre().equalsIgnoreCase(articulox.getNombre())){
                                                                articulox.setCantidad(articulox.getCantidad() - articulo.getCantidad());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    inicio_sesion.getForma_de_pago().getBanco().setSaldo(inicio_sesion.getForma_de_pago().getBanco().getSaldo() - inicio_sesion.getCarrito_compras().calcularTotal());
                                                    Factura factura = new Factura(inicio_sesion.getid(), inicio_sesion.getCarrito_compras(), "Marzo", inicio_sesion.getCarrito_compras().calcularTotal(), "Paypal", "l");
                                                    inicio_sesion.gethistorial_compras().add(factura);
                                                    System.out.println("________________________________________________");
                                                    System.out.println("Id factura: \n" + inicio_sesion.getid() + "\nLista Articulos: ");
                                                    inicio_sesion.getCarrito_compras().Mostrar_articulos();
                                                    System.out.println("\nFecha: " + "date" + "\nTotal pagado: " + inicio_sesion.getCarrito_compras().calcularTotal() + "\nForma de pago: " + "banco" + "\nDestino: " + inicio_sesion.getDireccion());
                                                    System.out.println("________________________________________________");
                                                    inicio_sesion.getCarrito_compras().getListaArticulos().clear();
                                                    System.out.println("Gracias por tu compra!!");
                                                }
                                                else{
                                                    System.out.println("No tienes saldo suficiente.");
                                                }
                                            }
                                            else{
                                                System.out.println("No tienes una cuemta bancaria enlazada a tu cuenta.");
                                            }
                                            break;
                                        default:
                                            System.out.println("Opción no válida.");
                                            break;
                                    }
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                                    break;
                            }
                        }
                    }
                    else{
                        System.out.println("Inicie sesion primero para poder ingresar a su carrito de compras.");
                    }
                    break;
                case 3:
                    if (inicio_sesion != null) {
                        System.out.println("1. Tazas");
                        System.out.println("2. Llaveros");
                        System.out.println("3. Estuches para celular");
                        System.out.println("4. Tarros para agua");
                        System.out.println("5. Posters");
                        System.out.println("Elija el tipo de pedido personalizado:");
                        int opcionTipo = scanner.nextInt();
                        scanner.nextLine();

                        String tipo = "Tazas";
                        switch (opcionTipo) {
                            case 1:
                                tipo = "Tazas";
                                break;
                            case 2:
                                tipo = "Llaveros";
                                break;
                            case 3:
                                tipo = "Estuches para celular";
                                break;
                            case 4:
                                tipo = "Tarros para agua";
                                break;
                            case 5:
                                tipo = "Posters";
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }

                        System.out.println("Elija la temática del pedido personalizado:");
                        System.out.println("1. Anime");
                        System.out.println("2. Peliculas");
                        int opcionTematica = scanner.nextInt();
                        scanner.nextLine();

                        String tematica = "Anime";
                        switch (opcionTematica) {
                            case 1:
                                tematica = "Anime";
                                break;
                            case 2:
                                tematica = "Peliculas";
                                break;
                            default:
                                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                break;
                        }
                        String eleccion = "Nada";
                        System.out.println("Elija una de las siguientes opciones:");
                        if (tematica == "Anime"){
                            System.out.println("1. One Piece");
                            System.out.println("2. Demon Slayer");
                            int opcionEleccion = scanner.nextInt();
                            scanner.nextLine();
                            eleccion = "One piece";
                            switch (opcionTematica) {
                                case 1:
                                    eleccion = "One Piece";
                                    break;
                                case 2:
                                    eleccion = "Demon Slayer";
                                    break;
                                default:
                                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                    break;
                            }
                        }
                        else if (tematica == "Peliculas"){
                            System.out.println("1. El Hobbit");
                            System.out.println("2. Harry Potter");
                            int opcionEleccion = scanner.nextInt();
                            scanner.nextLine();
                            switch (opcionTematica) {
                                case 1:
                                    eleccion = "El hobbit";
                                    break;
                                case 2:
                                    eleccion = "Harry Potter";
                                    break;
                                default:
                                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                    break;
                            }
                        }
                        else{
                            System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                            break;
                        }
                        System.out.println("Ingrese la cantidad del articulo personalizado: ");
                        int cantidadP = scanner.nextInt();
                        scanner.nextLine();
                        Pedido_personalizado pedidoPersonalizado = new Pedido_personalizado(tipo, tematica, eleccion, cantidadP);

                        System.out.println("El precio del pedido personalizado es: $" + pedidoPersonalizado.getPrecio()*pedidoPersonalizado.getCantidad());
                        System.out.println("¿Desea proseguir con la compra? (S/N)");
                        String respuesta = scanner.nextLine();

                        if (respuesta.equalsIgnoreCase("S")) {
                            // Agregar el pedido personalizado al carrito de compras del usuario
                            //Corregir
                            inicio_sesion.getCarrito_compras().agregarProductoPersonalizado(pedidoPersonalizado);

                            // Agregar el pedido personalizado a la lista de pedidos personalizados
                            //Lista_pedidos_personalizados.agregarPedido(pedidoPersonalizado);

                            System.out.println("El pedido personalizado se ha agregado al carrito de compras y se ha registrado exitosamente.");
                        } else {
                            System.out.println("El pedido personalizado no se ha agregado al carrito de compras.");
                        }
                    } else {
                        System.out.println("Inicie sesión primero para poder realizar su pedido personalizado.");
                    }
                    break;
                case 4:
                    if (inicio_sesion == null){
                        inicio_sesion = Iniciar_sesion(Usuarios);
                    }
                    else{
                        System.out.println("Ya estas en una sesion.");
                    }
                    break;
                case 5:
                    if (inicio_sesion == null){
                        System.out.println("No estas en una sesion.");
                    }
                    else{
                        System.out.println("Se ha cerrado la sesion.");
                        inicio_sesion = null;
                    }
                    break;
                case 6:
                    Registrar_usuario();
                    break;
                case 7:
                    if (inicio_sesion != null){

                        do{
                            System.out.println("------Cuenta----------");
                            System.out.println("1. Ver perfil");
                            System.out.println("2. Editar perfil");
                            System.out.println("3. Editar contraseña");
                            System.out.println("4. Eliminar usuario");
                            System.out.println("5. Formas de pago");
                            System.out.println("6. Historial de compras");
                            System.out.println("0. Salir");
                            System.out.println("----------------------");
                            System.out.println("Ingrese una opcion: ");
                            opcion2 = scanner.nextInt();
                            switch(opcion2){
                                
                                case 1:
                                    inicio_sesion.Mostrar_perfil();
                                    break;
                                case 2:
                                    String nombre, apellido, direccion, telefono;
                                    System.out.println("Inserte el nuevo nombre.");
                                    scanner.nextLine();
                                    nombre = scanner.nextLine();
                                    System.out.println("Inserte el nuevo apellido.");
                                    apellido = scanner.nextLine();
                                    System.out.println("Inserte el nuevo telefono.");
                                    telefono = scanner.nextLine();
                                    System.out.println("Inserte la nueva direccion.");
                                    direccion = scanner.nextLine();
                                    inicio_sesion.editar_perfil(nombre, apellido, telefono, direccion);
                                    System.out.println("Los cambios han sido realizados con exito.");
                                    break;
                                    
                                case 3:
                                    String contraseña;
                                    System.out.println("Inserte la nueva contraseña: ");
                                    scanner.nextLine();
                                    contraseña = scanner.nextLine();
                                    inicio_sesion.editar_contrasena(contraseña);
                                    System.out.println("La contraseña se ha cambiado con exito.");
                                    break;
                                    
                                case 4:
                                    Usuarios.remove(inicio_sesion);
                                    System.out.println("El usuario ha sido eliminado con éxito.");
                                    inicio_sesion = null;
                                    break;
                                    
                                case 5:
                                    System.out.println("0: Salir | 1: Ver formas de pago | 2: Administrar");
                                    opcion3 = scanner.nextInt();
                                    switch(opcion3){
                                        case 0:
                                            break;
                                        case 1:
                                            //ver
                                            inicio_sesion.getForma_de_pago().mostrar_Formas();
                                            break;
                                        case 2:
                                            //editar
                                            System.out.println("0: Cancelar | 1: Agregar forma de pago | 2: Eliminar forma de pago | 3: Depositar");
                                            opcion4 = scanner.nextInt();
                                            switch(opcion4){
                                                case 0:
                                                    break;
                                                case 1:
                                                    //Agregar forma de pago
                                                    System.out.println("Agregar 1: Paypal | 2: Tarjeta de Credito | 3: Tarjeta de Debito | 4: Cuenta Bancaria | 0: Cancelar");
                                                    opcion4 = scanner.nextInt();
                                                    switch(opcion4){
                                                        case 0:
                                                            break;
                                                        case 1:
                                                            if(inicio_sesion.getForma_de_pago().PaypalExiste()){
                                                                System.out.println("Ya tienes un Paypal enlazado a tu cuenta.");
                                                            }
                                                            else{
                                                                //agregar Paypal
                                                                scanner.nextLine();
                                                                String correo, contrasena;
                                                                System.out.println("Ingrese el correo: ");
                                                                correo = scanner.nextLine();
                                                                System.out.println("Ingrese la contraseña: ");
                                                                contrasena = scanner.nextLine();
                                                                inicio_sesion.getForma_de_pago().getPaypal().setCorreo(correo);
                                                                inicio_sesion.getForma_de_pago().getPaypal().setContrasena(contrasena);
                                                            }
                                                            break;
                                                        case 2:
                                                            if(inicio_sesion.getForma_de_pago().CreditoExiste()){
                                                                System.out.println("Ya tienes una tarjeta de Crédito enlazada a tu cuenta.");
                                                            }
                                                            else{
                                                                //agregar Tarjeta de Crédito
                                                                scanner.nextLine();
                                                                String numero, fecha_vencimiento, CCV;
                                                                System.out.println("Ingrese el número de la tarjeta: ");
                                                                numero = scanner.nextLine();
                                                                System.out.println("Ingrese la fecha de vencimiento de la tarjeta de crédito (mes|año): ");
                                                                fecha_vencimiento = scanner.nextLine();
                                                                System.out.println("Ingrese el CCV: ");
                                                                CCV = scanner.nextLine();
                                                                inicio_sesion.getForma_de_pago().getCredito().setNumero(numero);
                                                                inicio_sesion.getForma_de_pago().getCredito().setFecha_vencimiento(fecha_vencimiento);
                                                                inicio_sesion.getForma_de_pago().getCredito().setCCV(CCV);
                                                            }
                                                            break;
                                                        case 3:
                                                            if(inicio_sesion.getForma_de_pago().DebitoExiste()){
                                                                System.out.println("Ya tienes una tarjeta de Débito enlazada a tu cuenta.");
                                                            }
                                                            else{
                                                                //agregar Tarjeta de Débito
                                                                scanner.nextLine();
                                                                String numero, fecha_vencimiento, CCV;
                                                                System.out.println("Ingrese el número de la tarjeta: ");
                                                                numero = scanner.nextLine();
                                                                System.out.println("Ingrese la fecha de vencimiento de la tarjeta de débito (mes|año): ");
                                                                fecha_vencimiento = scanner.nextLine();
                                                                System.out.println("Ingrese el CCV: ");
                                                                CCV = scanner.nextLine();
                                                                inicio_sesion.getForma_de_pago().getDebito().setNumero(numero);
                                                                inicio_sesion.getForma_de_pago().getDebito().setFecha_vencimiento(fecha_vencimiento);
                                                                inicio_sesion.getForma_de_pago().getDebito().setCCV(CCV);
                                                            }
                                                            break;
                                                        case 4:
                                                            if(inicio_sesion.getForma_de_pago().BancoExiste()){
                                                                System.out.println("Ya tienes una cuenta bancaria enlazada a tu cuenta.");
                                                            }
                                                            else{
                                                                //agregar cuenta bancaria
                                                                scanner.nextLine();
                                                                String numero_root, numero_cuenta_corriente;
                                                                System.out.println("Ingrese el root bancario: ");
                                                                numero_root = scanner.nextLine();
                                                                System.out.println("Ingrese el número de la cuenta corriente: ");
                                                                numero_cuenta_corriente = scanner.nextLine();
                                                                inicio_sesion.getForma_de_pago().getBanco().setNumero_root(numero_root);
                                                                inicio_sesion.getForma_de_pago().getBanco().setNumero_cuenta_corriente(numero_cuenta_corriente);
                                                            }
                                                            break;
                                                        default:
                                                            break;
                                                    }
                                                    break;
                                                case 2:
                                                    //Eliminar forma de pago
                                                    int a, b, c, d;
                                                    a = 0;
                                                    b = 0;
                                                    c = 0;
                                                    d = 0;
                                                    if(inicio_sesion.getForma_de_pago().PaypalExiste()){
                                                        a = 1;
                                                    }
                                                    if(inicio_sesion.getForma_de_pago().CreditoExiste()){
                                                        b = 1;
                                                    }
                                                    if(inicio_sesion.getForma_de_pago().DebitoExiste()){
                                                        c = 1;
                                                    }
                                                    if(inicio_sesion.getForma_de_pago().BancoExiste()){
                                                        d = 1;
                                                    }
                                                    if((a+b+c+d) > 0){
                                                        if (a == 1){
                                                            inicio_sesion.getForma_de_pago().mostrarPaypal();
                                                        }
                                                        if (b == 1){
                                                            inicio_sesion.getForma_de_pago().mostrarCredito();
                                                        }
                                                        if (c == 1){
                                                            inicio_sesion.getForma_de_pago().mostrarDebito();
                                                        }
                                                        if (d == 1){
                                                            inicio_sesion.getForma_de_pago().mostrarBanco();
                                                        }
                                                        System.out.println("Eliminar 1: Paypal | 2: Tarjeta de Credito | 3: Tarjeta de Debito | 4: Cuenta Bancaria | 0: Cancelar");
                                                        opcion5 = scanner.nextInt();
                                                        switch(opcion5){
                                                            case 1:
                                                                if(a == 1){
                                                                    inicio_sesion.getForma_de_pago().setPaypal(new Paypal());
                                                                    a = 0;
                                                                }
                                                                else{
                                                                    System.out.println("No tienes un Paypal enlazado a tu cuenta.");
                                                                }
                                                                break;
                                                            case 2:
                                                                if(b == 1){
                                                                    b = 0;
                                                                    inicio_sesion.getForma_de_pago().setCredito(new Tarjeta_Credito());
                                                                }
                                                                else{
                                                                    System.out.println("No tienes una tarjeta de Crédito enlazada a tu cuenta.");
                                                                }
                                                                break;
                                                            case 3:
                                                                if(c == 1){
                                                                    c = 0;
                                                                    inicio_sesion.getForma_de_pago().setDebito(new Tarjeta_Debito());
                                                                }
                                                                else{
                                                                    System.out.println("No tienes una tarjeta de Débito enlazada a tu cuenta.");
                                                                }
                                                                break;
                                                            case 4:
                                                                if(d == 1){
                                                                    d = 0;
                                                                    inicio_sesion.getForma_de_pago().setBanco(new Banco());
                                                                }
                                                                else{
                                                                    System.out.println("No tienes una cuenta bancaria enlazada a tu cuenta.");
                                                                }
                                                                break;
                                                            case 0:
                                                                break;
                                                            default:
                                                                System.out.println("Opción no válida.");
                                                                break;
                                                        }
                                                    }
                                                    else{
                                                        System.out.println("No tienes asociada ninguna forma de pago.");
                                                    }
                                                    break;
                                                    
                                                case 3:
                                                    inicio_sesion.getForma_de_pago().mostrar_Formas();
                                                    System.out.println("Seleccionar forma de pago 1: Paypal | 2: Tarjeta de Crédito | 3: Tarjeta de Débito | 4: Cuenta Bancaria | 0: Cancelar");
                                                    opcion5 = scanner.nextInt();
                                                    scanner.nextLine();
                                                    switch(opcion5){
                                                        case 0:
                                                            break;
                                                        case 1:
                                                            if(inicio_sesion.getForma_de_pago().PaypalExiste()){
                                                                System.out.print("Dinero a depositar: ");
                                                                double dinero = scanner.nextDouble();
                                                                inicio_sesion.getForma_de_pago().getPaypal().setSaldo(inicio_sesion.getForma_de_pago().getPaypal().getSaldo() + dinero);
                                                            }
                                                            else{
                                                                System.out.println("No tienes un Paypal enlazado a tu cuenta.");
                                                            }
                                                            break;
                                                        case 2:
                                                            if(inicio_sesion.getForma_de_pago().CreditoExiste()){
                                                                System.out.println("No tienes una tarjeta de Crédito enlazada a tu cuenta.");
                                                                double dinero = scanner.nextDouble();
                                                                inicio_sesion.getForma_de_pago().getCredito().setSaldo(inicio_sesion.getForma_de_pago().getCredito().getSaldo() + dinero);
                                                            }
                                                            break;
                                                        case 3:
                                                            if(inicio_sesion.getForma_de_pago().DebitoExiste()){
                                                                System.out.println("No tienes una tarjeta de Débito enlazada a tu cuenta.");
                                                                double dinero = scanner.nextDouble();
                                                                inicio_sesion.getForma_de_pago().getDebito().setSaldo(inicio_sesion.getForma_de_pago().getDebito().getSaldo() + dinero);
                                                            }
                                                            break;
                                                        case 4:
                                                            if(inicio_sesion.getForma_de_pago().BancoExiste()){
                                                                System.out.println("No tienes una cuenta bancaria enlazada a tu cuenta.");
                                                                double dinero = scanner.nextDouble();
                                                                inicio_sesion.getForma_de_pago().getBanco().setSaldo(inicio_sesion.getForma_de_pago().getBanco().getSaldo() + dinero);
                                                            }
                                                            break;
                                                        default:
                                                            System.out.println("Selección no válida.");
                                                            break;
                                                    }
                                                    break;
                                                    
                                                default:
                                                    System.out.println("Opción inválida.");
                                                    break;
                                            }
                                            break;
                                        default:
                                            System.out.println("Opción inválida.");
                                            break;
                                    }
                                    break;
                                case 6:
                                    if (inicio_sesion.gethistorial_compras().isEmpty()){
                                        System.out.println("No ha realizado compras");
                                    }
                                    else{
                                       inicio_sesion.mostrarhistorial();
                                    }
                                    break;
                                case 0:
                                    break;
                                
                                default:
                                    System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                                    break;
                            }
                        }while(opcion2 !=0 && opcion2 != 4);
                    }
                    else{
                        System.out.println("Inicia sesion para ver tu cuenta");
                    }
            case 0:
                break;
            default:
                System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                break;
            }
        } while(opcion != 0);
        System.out.println("¡Hasta luego!");
    }
}