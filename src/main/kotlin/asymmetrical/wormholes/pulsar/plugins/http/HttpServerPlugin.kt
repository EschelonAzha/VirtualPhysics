package asymmetrical.wormholes.pulsar.plugins.http

import asymmetrical.machine.threads.Energy
import asymmetrical.wormholes.pulsar.plugins.Director
import asymmetrical.wormholes.pulsar.plugins.ServerPlugin
import asymmetrical.wormholes.pulsar.plugins.WaitForData
import asymmetrical.wormholes.pulsar.plugins.http.wormhole.composites.HttpMessage
import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage


class HttpServerPlugin : ServerPlugin, INebula {
    lateinit var director:HttpDirector
    constructor() : super() {
    }
    override fun i(energy: Energy, outlet: IOutlet) : HttpServerPlugin {
        super.i(energy, outlet)
        director = HttpDirector(outlet)
        return this
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun run() : Int {
        val waitForData = WaitForData(energy, getOutlet())
        while (true) {
            val dataAvailable:Int = waitForData.wait()
            if (dataAvailable == WaitForData.Static.TERMINATE) {
                getOutlet().close()
                return Static.TERMINATE
            }
            if (dataAvailable == WaitForData.Static.NO_DATA) {
                continue
            }
            director.setMessage(popMessage())
            if (!director.execute()) {
                return Static.UPGRADE
            }
            println("HTTP Socket Closed")
            getOutlet().close()
            return Static.TERMINATE
        }
    }

    private fun getDirector() : Director {
        var record      :ByteArray  = getOutlet().pop() as ByteArray

        val message: HttpMessage = HttpMessage(record)
        return HttpDirector(getOutlet()).setMessage(message)
    }
    private fun popMessage(): SocketMessage {
        var record: ByteArray = getOutlet().pop() as ByteArray
        return HttpMessage(record)
    }
}