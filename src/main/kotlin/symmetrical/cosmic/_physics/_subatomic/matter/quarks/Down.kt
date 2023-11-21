package symmetrical.cosmic._physics._subatomic.matter.quarks

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic.__recycle.Recycler
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion


class Down(
    private val fermion: IFermion = Fermion(Down::class),
) : Quark(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(Down::class),
    )
    companion object {
        const val VALUE            = "VALUE"
        const val FIELD_NAME       = "FIELD-NAME"
        const val TEST_PROPERTY    = "TEST_PROPERTY"
    }


    override fun absorb(photon: Photon) : Photon {
        return super.absorb(photon.propagate())
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return fermion.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return fermion.getClassId()
    }
    override fun i() : Down {
        super.i()
        return this
    }

    override fun dissipate() : Unit {
        Recycler.Down_dissipate(this)
    }
}