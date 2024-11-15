// Evento para manejar el registro de usuario
let botonRegistrar = document.getElementById("btn-registrar");

botonRegistrar.addEventListener("click", evento => {
    evento.preventDefault(); // Prevenir el envío del formulario
    registrarUsuario();
});

let registrarUsuario = async () => {
    let campos = {};

    campos.nombre = document.getElementById("nombre").value;
    campos.email = document.getElementById("email").value;
    campos.password = document.getElementById("contraseña").value; // Asegúrate de que el ID sea correcto

    try {
        const peticion = await fetch("http://localhost:8080/biblioteca/api/v1/usuarios", {
            method: "POST",
            headers: {
                "Accept": "application/json",
                "Content-Type": "application/json",
                "Cache-Control": "no-cache" // Añadido para evitar el uso de la caché
            },
            body: JSON.stringify(campos)
        });

        // Verificamos si la respuesta es exitosa
        if (peticion.ok) {
            const respuesta = await peticion.json();
            console.log('Usuario registrado con éxito:', respuesta);
            // Aquí puedes mostrar un mensaje de éxito o redirigir a otra página
        } else {
            // Si la respuesta no es exitosa, manejamos el error
            console.error('Error al registrar el usuario:', peticion.status);
        }
    } catch (error) {
        console.error('Error en la solicitud:', error);
    }
};
