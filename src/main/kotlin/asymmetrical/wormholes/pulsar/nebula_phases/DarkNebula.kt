package asymmetrical.wormholes.pulsar.nebula_phases

import symmetrical.cosmic.cosmology.INebula
import symmetrical.cosmic.cosmology.NebulaPhase

/*
1. Dark nebulae are the first phase of most nebulae. They are made up of dust and gas that is so dense that it blocks out the light from stars behind it
 */
class DarkNebula : NebulaPhase, INebula {

    constructor(parent:INebula) : super(parent) {
    }
    override fun nextPhase() : INebula {
        return this
    }
    override fun onClose  ()                 : Unit {
    }
    override fun onMessage(message:String)   : Boolean {
        return true
    }
    override fun onOpen   ()                 : Unit {
    }
}