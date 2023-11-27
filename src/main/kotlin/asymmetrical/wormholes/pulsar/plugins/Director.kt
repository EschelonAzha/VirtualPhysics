package asymmetrical.wormholes.pulsar.plugins

import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics._subatomic.spacial.Composition
import symmetrical.cosmic._physics.atomic.substance.ions.Compound
import symmetrical.cosmic.wormholes.pulsar.socket.SocketMessage

open class Director : Compound {
    object Static {
        const val LAST = Compound.Static.LAST
    }
    private lateinit var socketMessage : SocketMessage
    protected val        outlet        : IOutlet

    constructor(outlet: IOutlet) {

        this.outlet = outlet
    }

    fun setMessage(message: SocketMessage) : Director {
        for (i in 0 until size()) {
            (get(i) as InspectorTask).setMessage(message)
        }
        return this
    }

    fun execute() : Boolean {
        for (i in 0 until size()) {
            val composition     : Composition = get(i)                  as Composition
            val inspector       : Inspector     = composition.getFirst()  as Inspector
            var task            : Task          = composition.getLast()   as Task

            val recordCount = inspector.inspect()
            for (i in 0 until recordCount) {
                task.getPayload().add(inspector.getPayload().popLeft())
                task.run()
            }
            if (recordCount > 0)
                return false

        }
        return true  // close socket
    }
    fun executex() : Boolean {
        for (i in 0 until size()) {
            val composition     : Composition = get(i)                  as Composition
            val inspector       : Inspector     = composition.getFirst()  as Inspector
            var task            : Task          = composition.getLast()   as Task

            val recordCount = inspector.inspect()
            if (recordCount>0) {
                task.getPayload().add(inspector.getPayload().popLeft())
                return task.run()
            }
        }
        return true  // close socket
    }
}