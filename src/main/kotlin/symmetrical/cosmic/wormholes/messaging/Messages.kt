package symmetrical.cosmic.wormholes.messaging

import symmetrical.cosmic.__recycle.Absorber

object Messages {
    fun detect(message:String) : Message {
        val (emitter, remainder) = Absorber.materialize(message)
        return emitter as Message
    }
}