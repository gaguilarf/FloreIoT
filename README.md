# FloreIoT

FloreIoT es una aplicación móvil para la supervisión y control de sistemas automáticos de riego utilizando válvulas y microcontroladores ESP32. Permite visualizar en tiempo real la temperatura y humedad del entorno, así como automatizar y personalizar el proceso de riego.

## Características principales
- **Monitoreo en tiempo real:** Visualización gráfica de temperatura y humedad.
- **Automatización:** Configuración de valores umbral para activar el riego automático.
- **Control manual:** Posibilidad de activar el riego de forma remota ante cualquier eventualidad.
- **Historial y reportes:** Consulta de registros históricos y reportes de riego (si está implementado).
- **Notificaciones:** Alertas sobre condiciones críticas o acciones automáticas (si está implementado).

## Tecnologías utilizadas
- **Android (Kotlin/Java)**
- **Material Design**
- **Firebase**
- **ESP32** para la gestión de sensores y actuadores

## Instalación y uso
1. Clona este repositorio:
   ```bash
   git clone https://github.com/gaguilarf/FloreIoT.git
   ```
2. Abre el proyecto en Android Studio.
3. Configura los servicios necesarios (por ejemplo, Firebase) siguiendo la documentación interna.
4. Compila y ejecuta la aplicación en un dispositivo físico o emulador.

## Configuración del hardware
- Conecta los sensores de humedad y temperatura al ESP32.
- Configura la válvula de riego según el diagrama de conexiones.
- Asegúrate de que el ESP32 tenga conectividad WiFi y esté correctamente enlazado con la app.

## Contribuciones
¡Las contribuciones son bienvenidas! Por favor, abre un issue o pull request para sugerencias, mejoras o correcciones.

## Licencia
Este proyecto está bajo la licencia MIT. Consulta el archivo LICENSE para más detalles.

---

Desarrollado por el equipo de FloreIoT.
