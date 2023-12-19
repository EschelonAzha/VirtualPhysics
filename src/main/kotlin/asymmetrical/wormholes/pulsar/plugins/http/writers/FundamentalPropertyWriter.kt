package asymmetrical.wormholes.pulsar.plugins.http.writers


import symmetrical.cosmic._physics.atomic.atoms.Atom
import symmetrical.cosmic.wormholes.pulsar.socket.IOutlet
import symmetrical.cosmic._physics.atomic.substance.ions.Compound

abstract class FundamentalPropertyWriter {
    protected val outlet: IOutlet
    constructor(outlet: IOutlet) {
        this.outlet = outlet
    }
    fun write(compound: Compound) {
        for (i in 0 until compound.size()) {
            write(compound.get(i) as Atom)
        }
    }
    abstract fun write(atom:Atom) : FundamentalPropertyWriter
}