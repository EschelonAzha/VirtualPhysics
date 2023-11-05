package asymmetrical.wormholes.pulsar.sockets


import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic.wormholes.pulsar.socket.Outlet
import java.io.InputStream
import java.io.OutputStream
import java.net.Socket

open class ServerOutlet : Outlet, IOutlet {
    private var socket      : Socket
    private var input       : InputStream
    private var output      : OutputStream

    constructor(socket:Socket) {
        this.socket = socket
        this.input  = socket.getInputStream()
        this.output = socket.getOutputStream()
    }

    fun getSocket() : Socket {
        return socket
    }
    fun getInputStream() : InputStream {
        return input
    }
    fun getOutputStream() : OutputStream {
        return output
    }
    override fun read() : Int {
        if (closed)
            return -1

        try {
            var available = input.available()
            if (available==0) {
                return 0
            }
            var byteArray = ByteArray(available)
            input.read(byteArray, 0, available)
            records.add(byteArray)
        } catch(e:Exception) {
            return -1
        }

        return records.size();
    }
    override fun write(byteArray:ByteArray) : Boolean {
        try {
            output.write(byteArray)
            return true
        } catch (e:Exception) {
            return false
        }
    }
    override fun write(item:String) : Boolean {
        val byteArray = item.toByteArray()
        write(byteArray)
        return true
    }
    override fun flush() : IOutlet {
        try {
            output.flush()
        } catch (e:Exception) {
        }
        return this
    }
    override fun close() : IOutlet {
        flush()
        closed = true
        try {
            input.close()
            output.close()
            socket.close()
        } catch (e:Exception) {

        }
        return this
    }

}