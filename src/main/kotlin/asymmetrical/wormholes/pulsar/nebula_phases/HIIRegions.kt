package asymmetrical.wormholes.pulsar.nebula_phases

import symmetrical.cosmic.cosmology.INebula


/*
4. H II regions are a type of emission nebula that is made up of ionized hydrogen gas. H II regions are the most common type of nebula in the Milky Way galaxy.
 */
class HIIRegions : EmissionNebula {
    constructor(parent: INebula) : super(parent) {

    }
    override fun nextPhase() : INebula {
        return this
    }
}
