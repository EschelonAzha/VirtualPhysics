package websites.tests

import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.util.concurrent.CompletionStage

object XTestSockets {


    class WebSocketClient(private val uri: URI) {
        fun start() {
            val client = HttpClient.newHttpClient()

            client.newWebSocketBuilder()
                .buildAsync(uri, WebSocketListener())
                .join()
        }

        private inner class WebSocketListener : WebSocket.Listener {
            override fun onOpen(webSocket: WebSocket) {
                println("Connected to WebSocket server.")
            }

            override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
                println("Received message from server: $data")
                return super.onText(webSocket, data, last)
            }

            override fun onClose(webSocket: WebSocket, statusCode: Int, reason: String): CompletionStage<*> {
                println("Disconnected from WebSocket server. Reason: $reason")
                return super.onClose(webSocket, statusCode, reason)
            }

            override fun onError(webSocket: WebSocket, error: Throwable) {
                error.printStackTrace()
                return super.onError(webSocket, error)
            }
        }
    }




    @JvmStatic
    fun main(args: Array<String>) {
        val serverUri = URI("ws://localhost:8080/websocket") // Replace with your server URI
        val client = WebSocketClient(serverUri)
        client.start()
    }
}