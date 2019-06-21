package com.todoist.pojo

enum class Avatar constructor(private val size: Int, private val arg: String) {
    // In ascending order of size.
    SMALL(35, "small"),
    MEDIUM(60, "medium"),
    BIG(195, "big"),
    HUGE(640, "s640");

    fun getUrl(imageId: String?): String? {
        return if (imageId != null) {
            "https://dcff1xvirvpfp.cloudfront.net/" + imageId + "_" + getForSize(size).arg + ".jpg"
        } else {
            null
        }
    }

    companion object {
        /**
         * Returns the first [Avatar] to be larger than `size`. If none exist, returns the largest one.
         */
        @JvmStatic
        fun getForSize(size: Int) = values().firstOrNull { it.size >= size } ?: values().last()

        /**
         * Returns an array of [Avatar] ordered by how optimal they are. The first should be the best, followed by
         * larger sizes and finally the smaller ones.
         */
        @JvmStatic
        fun getOrderedForSize(size: Int): Array<Avatar> {
            val bestAvatar = getForSize(size)
            val bestOrdinal = bestAvatar.ordinal

            return arrayListOf<Avatar>().apply {
                add(0, bestAvatar)

                for (i in 1 until values().size) {
                    val prevOrdinal = this[i - 1].ordinal
                    val ordinal = when {
                        prevOrdinal >= bestOrdinal -> prevOrdinal + if (prevOrdinal < values().size - 1) 1 else -1
                        else -> prevOrdinal - 1
                    }
                    add(i, values()[ordinal])
                }
            }.toTypedArray()
        }
    }
}
