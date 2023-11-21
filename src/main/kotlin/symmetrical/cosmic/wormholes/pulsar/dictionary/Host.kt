package symmetrical.cosmic.wormholes.pulsar.dictionary

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics.atomic.atoms.states.strings.QString
import symmetrical.cosmic.chemistry.diatomics.KeyValue
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Host(
    private val fermion: IFermion = Fermion(Host::class),
) : KeyValue(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Host::class),
    )
    constructor(key: QString, value: QString) : this() {
        add(key)
        add(value)
    }

}