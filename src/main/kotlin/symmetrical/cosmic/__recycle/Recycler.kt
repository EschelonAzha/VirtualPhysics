package symmetrical.cosmic.__recycle


import symmetrical.cosmic._physics._subatomic.matter.quarks.Down
import symmetrical.cosmic._physics._subatomic.matter.quarks.Up


class Recycler {
    companion object {
        val up   : ArrayList<Up>    = ArrayList(1000)
        val down : ArrayList<Down>  = ArrayList(1000)

        fun Down_() : Down {
            var end = down.size - 1;
            if (end == -1)
                return Down()

            var quark = down.removeAt(end)
            return quark as Down
        }

        fun Down_dissipate(quark: Down) : Unit{
            down.add(quark)
            return
        }
        fun Up_() : Up {
            var end = up.size - 1;
            if (end == -1)
                return Up()

            var up = up.removeAt(end)
            return up as Up
        }
        fun Up_dissipate(up: Up) : Unit{
            Companion.up.add(up)
            return
        }

    }
}