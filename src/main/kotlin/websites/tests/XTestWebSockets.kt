package websites.tests

import java.net.URI
import java.net.http.HttpClient
import java.net.http.WebSocket
import java.net.http.WebSocket.Listener
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionStage
class SimpleWebSocketListener : Listener {
    override fun onOpen(webSocket: WebSocket) {
        println("Connected to server.")

        // Send a message to the server
        webSocket.sendText("Hello, server!", true)
    }

    override fun onText(webSocket: WebSocket, data: CharSequence, last: Boolean): CompletionStage<*> {
        println("Received message from server: $data")
        return CompletableFuture.completedFuture(null)
    }

    override fun onError(webSocket: WebSocket, error: Throwable) {
        println("WebSocket error occurred: ${error.message}")
    }
    override fun onClose(webSocket: WebSocket, statusCode: Int, reason: String): CompletionStage<*> {
        println("WebSocket connection closed. Code: $statusCode, Reason: $reason")
        return CompletableFuture.completedFuture(null)
    }
}
object XTestWebSockets {
    @JvmStatic
    fun main() {
        val uri = URI("ws://localhost:9090/socket") // Replace with the appropriate server URL

        val httpClient = HttpClient.newHttpClient()
        val webSocketBuilder = httpClient.newWebSocketBuilder()
        val webSocketListener = SimpleWebSocketListener()

        webSocketBuilder.buildAsync(uri, webSocketListener)
            .whenComplete { webSocket: WebSocket?, throwable: Throwable? ->
                if (throwable != null) {
                    println("Failed to establish WebSocket connection: ${throwable.message}")
                }
            }

        // Wait for WebSocket connection to stay alive
        Thread.sleep(Long.MAX_VALUE)
    }
}