package symmetrical.cosmic.physics.subatomic.luminescent

import symmetrical.cosmic.absorber.Absorber
import symmetrical.cosmic.transpectors.transpectors.Photons
import symmetrical.cosmic.transpectors.transpectors.Strings
import symmetrical.cosmic.physics.subatomic.balanced.values.Field
import symmetrical.cosmic.physics.subatomic.balanced.values.IField
import symmetrical.cosmic.physics.subatomic.bosons.Photon

/*
https://en.wikipedia.org/wiki/Quasiparticle
 */
class QuasiParticle(
    private val _field:Field=Field()
) : IField by _field,
    IQuasiParticle
{
    constructor() : this(
        Field()
    )
    constructor(value:Any?) : this(
        Field()
    ){
        _field.setContent(value)
    }

    override fun absorb(photon: Photon) : Photon {

        var (type, leftover) = Strings.remainder(Field.Static.TYPE_LTH, photon.propagate().radiate())
        if (type == Field.Static.NULL) {
            _field.setContent(null)
            return Photon(leftover)
        }
        if (type == Field.Static.BOOLEAN) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content == "true")
            return Photon(remainder)
        }
        if (type == Field.Static.BYTE) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.INT) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content.toInt())
            return Photon(remainder)
        }
        if (type == Field.Static.DOUBLE) {
            var (content, remainder) = Photons.parse(Field.Static.NUMBERS_LTH, leftover)
            _field.setContent(content.toDouble())
            return Photon(remainder)
        }
        if (type == Field.Static.STRING1) {
            var (content, remainder) = Photons.parse(Field.Static.STRING1_LTH, leftover)
            _field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.STRING2) {
            var (content, remainder) = Photons.parse(Field.Static.STRING2_LTH, leftover)
            _field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.STRING3) {
            var (content, remainder) = Photons.parse(Field.Static.STRING3_LTH, leftover)
            _field.setContent(content)
            return Photon(remainder)
        }
        if (type == Field.Static.VECTOR) {
            var (content, remainder) = Photons.parse(Field.Static.VECTOR_LTH, leftover)
            _field.setContent(content)
            return Photon(remainder)
        }
        println("!!!!!!!!!!!!!!!!!!!!!ERROR OCCURED IN QuantumPhotonicField:ABSORB!!!!!!!!!!!!!!!!!!!!!")
        return Photon("")
    }

    override fun emit() : Photon {
        return Photon(radiate())
    }

    public fun getClassId() : String {
        return getLocalClassId()
    }

    fun getField() : Field {
        return _field
    }

    fun radiate() : String {
        val prefix = getLocalClassId()+_field.getType()
        if (_field.getType() == Field.Static.NULL)
            return prefix
        if (_field.getType() == Field.Static.BOOLEAN)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.BYTE)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.INT)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.DOUBLE)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.STRING1)
            return prefix+ Photon.toPhoton1(_field.getContent())
        if (_field.getType() == Field.Static.STRING2)
            return prefix+ Photon.toPhoton2(_field.getContent())
        if (_field.getType() == Field.Static.STRING3)
            return prefix+ Photon.toPhoton3(_field.getContent())

        return prefix+ Photon.toPhoton3(_field.getContent())
    }

    override fun toString() : String {
        return _field.toString()
    }

    private fun getLocalClassId() : String {
        return Absorber.getClassId(QuasiParticle::class)
    }
}