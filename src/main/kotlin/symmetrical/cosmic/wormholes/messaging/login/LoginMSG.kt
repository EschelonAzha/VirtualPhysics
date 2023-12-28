package symmetrical.cosmic.wormholes.messaging.login

import symmetrical.cosmic._physics._subatomic.bosons.Photon
import symmetrical.cosmic.wormholes.messaging.Message
import symmetrical.cosmic.dictionary.atoms.PasswordFld
import symmetrical.cosmic.dictionary.atoms.UseridFld
import symmetrical.cosmic._physics._subatomic.luminescent.IMatter
import symmetrical.cosmic._physics._subatomic.luminescent.Matter

class LoginMSG(
    private val matter: IMatter = Matter(LoginMSG::class, LoginMSG::class),
) : Message(),
    IMatter by matter
{
    constructor() : this(
        Matter(LoginMSG::class, LoginMSG::class),
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
        matter.check(photon);

        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon(radiate())
    }
    override fun getClassId() : String {
        return matter.getClassId()
    }
    fun getPassword() : PasswordFld {
        return get(Static.PASSWORD) as PasswordFld
    }
    fun getUserId() : UseridFld {
        return get(Static.USERID) as UseridFld
    }
    private fun radiate() : String {
        return matter.getClassId()+super.emit().radiate()
    }
}