package symmetrical.cosmic.wormholes.messaging.login

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic.dictionary.PasswordFld
import symmetrical.cosmic.dictionary.UseridFld
import symmetrical.cosmic._physics._subatomic.luminescent.ILuminescent
import symmetrical.cosmic._physics._subatomic.luminescent.Luminescent

class LoginMSG(
    private val luminescent: ILuminescent = Luminescent(LoginMSG::class),
) : Message(),
    ILuminescent by luminescent
{
    constructor() : this(
        Luminescent(LoginMSG::class),
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


    override fun absorb(photon: Photon) : Photon {
        luminescent.check(photon);

        return super.absorb(photon.propagate())
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }
    private fun radiate() : String {
        return luminescent.getClassId()+super.emit().radiate()
    }
    override fun getClassId() : String {
        return luminescent.getClassId()
    }
    fun getUserId() : UseridFld {
        return get(Static.USERID) as UseridFld
    }
    fun getPassword() : PasswordFld {
        return get(Static.PASSWORD) as PasswordFld
    }
}