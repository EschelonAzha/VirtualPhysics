package asymmetrical.wormholes.pulsar.nebula_phases

import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.cosmology.NebulaPhase

/*
6. Supernova remnants are formed when a star explodes in a supernova. The expanding shell of gas and dust from the explosion eventually disperses into space
 */
class SupernovaRemnant : NebulaPhase, INebula {

    constructor(parent:INebula) : super(parent) {
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun onOpen   ()                 : Unit {

    }
    override fun onClose  ()                 : Unit {

    }
    override fun onMessage(message:String)   : Boolean {
        return true
    }
}