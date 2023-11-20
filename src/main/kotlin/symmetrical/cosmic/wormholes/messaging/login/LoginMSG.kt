package symmetrical.cosmic.wormholes.messaging.login

import symmetrical.cosmic.__recycle.Absorber
import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic.dictionary.PasswordFld
import symmetrical.cosmic.dictionary.UseridFld
import symmetrical.cosmic._physics._subatomic.fermions.IQuantumEntanglement
import symmetrical.cosmic._physics._subatomic.fermions.QuantumEntanglement

class LoginMSG(
    private val entanglement: IQuantumEntanglement = QuantumEntanglement()
) : Message(entanglement),
    IQuantumEntanglement by entanglement
{
    constructor() : this(
        QuantumEntanglement()
    )
    object Static {
        const val USERID    : Int = Message.Static.LAST + 1
        const val PASSWORD  : Int = Message.Static.LAST + 2
        const val LAST      : Int = PASSWORD

    }
    override fun i() : LoginMSG {
        super.i()
        add(UseridFld())
        add(PasswordFld())
        return this
    }

    private fun check(photon: Photon) : Unit {
        val classId = getLocalClassId()

        val radiation = photon.radiate()
        if (radiation.startsWith(classId))
            return
        println("Radiation Leak in: "+this::class.simpleName)
        return;
    }
    override fun absorb(photon: Photon) : Photon {
        check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return getLocalClassId()+super.emit().radiate()
    }
    private fun getLocalClassId() : String {
        return Absorber.getClassId(LoginMSG::class)
    }
    override fun getClassId() : String {
        return getLocalClassId()
    }
    fun getUserId() : UseridFld {
        return get(Static.USERID) as UseridFld
    }
    fun getPassword() : PasswordFld {
        return get(Static.PASSWORD) as PasswordFld
    }
}