package symmetrical.cosmic.wormholes.messaging.login


import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic._physics._subatomic.fermions.IFermion
import symmetrical.cosmic._physics._subatomic.fermions.Fermion

class ReadyMSG (
    private val fermion: IFermion = Fermion(ReadyMSG::class),
) : Message(),
    IFermion by fermion
{
    constructor() : this(
        Fermion(ReadyMSG::class),
    )
    object Static {
        const val LAST      : Int = Message.Static.LAST
    }

    override fun i() : ReadyMSG {
        super.i()
        return this
    }


    override fun absorb(photon: Photon) : Photon {
        fermion.check(photon);

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
}