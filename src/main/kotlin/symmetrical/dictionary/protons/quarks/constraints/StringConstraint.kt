package symmetrical.dictionary.protons.quarks.constraints

import symmetrical.physics.subatomic.balanced.Particle
import symmetrical.physics.subatomic.balanced.values.Field
import symmetrical.physics.subatomic.bosons.Photon
import symmetrical.physics.subatomic.luminescent.IMatter
import symmetrical.physics.subatomic.luminescent.Matter
import symmetrical.physics.subatomic.matter.bosons.ZBoson
import symmetrical.physics.subatomic.matter.quarks.Quark
import symmetrical.physics.subatomic.matter.quarks.Up

class StringConstraint (
    private val matterAntiMatter: IMatter = Matter().with(StringConstraint::class),
) : Up(),
    IMatter by matterAntiMatter
{
    init {
        setNotNull(false)
        setMaxLength(999999999)
        setMinLength(0)
    }

    fun isNotNull() : Boolean {
        return getSpin().isTrue()
    }
    fun getMaxLength() : Int {
        return getAngularMomentum().getField().toInt()
    }
    fun getMinLength() : Int {
        return getTemperature().getField().toInt()
    }
    override fun mediate(value: Quark, format: Quark, zBoson:ZBoson) : ZBoson {
        val field: Field = zBoson.getNewField()

        if (isNotNull()) {
            if (field.isNull()) {
                zBoson.setAccepted(false)
                zBoson.setReason("Must not be null")
                zBoson.setReasonCode(-1);
                return zBoson
            }
        }


        if (field.toString().length  < getMinLength()) {
            zBoson.setAccepted(false)
            zBoson.setReason("Value must not be less than: "+getMinLength()+" characters.")
            zBoson.setReasonCode(-2);
        }
        val debug = field.toString()
        val max = getMaxLength()
        if (field.toString().length > getMaxLength()) {
            zBoson.setAccepted(false)
            zBoson.setReason("Value must not exceed: "+getMaxLength()+" characters.")
            zBoson.setReasonCode(-3);
        }
        return zBoson
    }

    fun setNotNull(notNull:Boolean) : StringConstraint {
        getSpin().setContent(notNull)
        return this
    }
    fun setMaxLength(max:Int) : StringConstraint {
        getAngularMomentum().setContent(max)
        return this
    }
    fun setMinLength(max:Int) : StringConstraint {
        getTemperature().setContent(max)
        return this
    }





    // ########################### EMISSIONS ###########################
    override fun absorb(photon: Photon) : Photon {
        var remainder = photon.propagate()
        remainder = super.absorb(remainder)
        return remainder
    }
    override fun emit() : Photon {
        return Photon().with(radiate())
    }
    override fun getClassId() : String {
        return matterAntiMatter.getClassId()
    }
    private fun radiate() : String {
        if (Particle.Static.debuggingOn) {
            println("StringConstraint")
        }
        val classId:String = matterAntiMatter.getClassId()
        val quark  :String = super.emit().radiate()
        return classId+quark
    }
    // ########################### EMISSIONS ###########################
}