package asymmetrical.wormholes.pulsar.plugins.galaxy

import asymmetrical.machine.threads.Energy
import asymmetrical.wormholes.mail.Inbox
import asymmetrical.wormholes.pulsar.Galaxy
import asymmetrical.wormholes.pulsar.plugins.ServerPlugin
import asymmetrical.wormholes.pulsar.plugins.WaitForData
import asymmetrical.wormholes.pulsar.plugins.galaxy.wormhole.composites.SocketFramePing
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage


open class WSServerPlugin : ServerPlugin, INebula {
    private lateinit    var director            : WSDirector
    private lateinit    var galaxy              : Galaxy
    private             var inbox               : Inbox       = Inbox()
    private             var loggedIn            : Boolean     = true
    private             var sessionReady        : Boolean     = true


    constructor() : super() {
        return
    }
    override fun i(energy: Energy, outlet: IOutlet) : WSServerPlugin {
         super.i(energy, outlet)
         director = WSDirector(this, outlet)
         return this
    }
    fun close() : WSServerPlugin {
        getOutlet().close()
        println("Socket Closed")
        return this
    }
    fun getGalaxy() : Galaxy {
        return galaxy
    }
    fun isLoggedIn() : Boolean {
        return loggedIn
    }
    fun isSessionReady() : Boolean {
        return sessionReady
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun run() : Int {
        println("SocketServer")
        val waitForData = WaitForData(energy, getOutlet())
        onOpen()
        while (true) {
            val dataAvailable = waitForData.wait()

            if (dataAvailable == WaitForData.Static.PING_REQUIRED) {
                println("Sending Ping")
                if (!getOutlet().write(SocketFramePing().getByteArray())) {
                    return terminate()
                }
                continue
            }
            if (dataAvailable == WaitForData.Static.TERMINATE) {
                return terminate()
            }
            if (dataAvailable == WaitForData.Static.NO_DATA) {
                // Probably should make a frame socket out of this
                // and create my own OpCode to uniquely identify mail
                // then I can push the mail onto the IOutlet as if it
                // came from the socket directly but only do it if there
                // is no other data in the socket.   What do you think?
                val socketMessage = inbox.popLeft() ?: continue
            }
            if (dataAvailable==WaitForData.Static.DATA_AVAILABLE) {
                galaxy.showCount()
            }
            director.setMessage(popMessage())
            val result = director.execute()
            if (!result) {
                continue
            }
            return terminate()
        }

    }
    fun setGalaxy(galaxy:Galaxy) : Unit {
        this.galaxy = galaxy;
        return;
    }
    private fun terminate() : Int {
        close()
        onClose()
        return Static.TERMINATE
    }



    private fun popMessage(): SocketMessage {
        var record: ByteArray = getOutlet().pop() as ByteArray
        return SocketMessage(record)
    }
}