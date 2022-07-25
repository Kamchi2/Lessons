package com.example.android1leson66

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.android1leson66.databinding.FragmentMainBinding
import kotlin.ranges.random as random


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val data = arrayListOf<LessonModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding =
            FragmentMainBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
        val adapter = LessonAdapter(data)
        binding.recycler.adapter = adapter
        binding.recycler.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    private fun randomColor(): Int {
        when ((1..10).random()) {
            1 -> {
                return R.color.green
            }
            2 -> {
                return R.color.black
            }
            3 -> {
                return R.color.green
            }
            4 -> {
                return R.color.teal_700
            }
            5 -> {
                return R.color.teal_200
            }
            6 -> {
                return R.color.purple_700
            }
            7 -> {
                return R.color.blue
            }
            8 -> {
                return R.color.red
            }
            9 -> {
                return R.color.purple_200
            }
            10 -> {
                return R.color.grey
            }
            else -> {
                return R.color.teal_700
            }
        }
    }

    private fun loadData() {
        data.add(
            LessonModel(
                "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAABa1BMVEX///+SVjo0j9kwhs1+tFf/tTF5rVTq17zfzbPtjAzOvaXUwqqHUDb6nwz/qRKNTCvPubHw6Nzj0riQUjSmemj6mwDt3sgxjtz/ujCmaDkpg9N/tVMujd+Ctkx7smBDlchYn6n8z5/t0Kn/siCESzH/sRtSnLQ5kdT/vE//sTzi1dGpgmrq3s5tq4F0rnFwrHxeoqBjoIf+8N3/+/P/15r/ukD/9uj/4LH7uFz/0Ymgw4v1+f2qZSz/5Lz/wVp0qkr/yXT/7tO5bSrSfByZWjf/zHr7s03N4dD/58T/xWd0rOL/wVfm8PlgntfK3vFFkLOdwubwkxTegxfDcyS1ayyJRB78vWu71PB/s+Srze2z0dvo8uuMvIG+2LzM4dKpyqaTrFOdw5pRnK+Ovqk5i8GJtm6vzrOFuD5up2zk7t+FtIJTmJ3KmlW6l2WwlW7R4vLBiGKmbknZtpG8mIDDpZmgbFWdViTvvIzxoUTMX2gNAAAOrklEQVR4nO2d/V8TRx7HA3koKA8qIjUBtLduk2oFzROmQAIKVyIBo6jg+dBrT1t6tkevaq9//u1mZ3bneWczm5lNX/n8xoaEeef7ne/TPpBKjTTSSMOqsukFDFrPp//iiM/n5xHE6q7BpQxGz+enp6fnAWKlbdubZtcTu3qAjrbdH8o1K5vN1k2vKVZVAWDPUfeyrqy26UXFq78HiGt2jzBrV0Pe0zk7PO7p8KyjZZFqugcRZ6wskM31085x92A8n88vQOXz4w+7xwnnBIg+n1XbY/5e5/ik6KCNU3I4iyeJpuw5agDYZFmw8+JgnEUXUI4f/OOl9qXLykEMPJSVDw8fiuiAFq8vvfpW+9ol9XwGAmbX6Fdfr+TD+RwzXl8qLC2/1r96Ga35JpyhCrjXy0vLixKALmEmUygkknEvAJwnatQ37wqFTARCR4V3bwxxcFW2fUCkgHP18lXLXXM0wkxm6VWyYk4liwI68hFftwqZfggzmdaPJolItYGPWjNIAZdyDVgA641OmGslyIxVAGiv3UNr1NTPyxCwH8JcrpWUzLENNqHVCAo4dy/+2PKX2x9hrvWdaTZPsJLpNRSBFb8pZFQIPcRvTMO52gU+Wqv0foSdxj8zGXVCZzOuG8ZzMiFsmGD89KyIA/ZNmGutGEcswSjjH3ERCcD+Cc0jgjiKdfX35klABULHUY3BuarDag3rlyhAFULD4QaEGQvrJ34sxEqYa31vCi+oR0vowW9pQIdwAVU0wlzLXLOx5ZnQ3kaOvaT5HMIvMUUkzLVMFXBl4KNb6MFXDBM6zQKmH9hW5BLmlg0RAhNaaJj5jglImjSiDU1tRRBI3XrU18sWnwuxKNuIfMJcy0hPXGWY8J2MCTOFFbYNr3EJc+9MEAJAdLT2WgqQa8TFu8H7CUITHTEY4dvIzGI9JwfITZBFrg1zOf3xtOnlwiZySCrMCI0Y7EQSUH+wAXHGRgb461JhBhiRkzBW4JdE2VB7UoSzC+TQ99ImdIx4nR1OrxU4gPqN6DmphZxHW5fn44ZTP9jQhLp3InRSJM4wKm6RETmFTZFLqHlsA8b4SM29vhwFMFPg7EQQbFg2XNbaDHsVG+qkbyTiTAERZyeCYMMi1DpeBGNuC+kqvpFw0tuo7rJz4sKjAhtQby8Mh6SV4FB4tl/6YRETO9b0gg2TMNfSSAi2ITKeebMUBlhYler0e5UNh1BjKwy2ITK9kEiGRZnTpOO9YMMh1OimdHMf6qRL1yVN6AYbNqFGN62Aqjs48jLMSaV91CX8ssAh1NYmgkCDZMPXS0giYBIWpQHH0/nbLcMb0Qs0aHf/r1VEjNzvxNEIhOm3HBv+Wxdhgwo0RTQN3KGsWFiVjDKAML/MRtTW6rfJzmkdXeDCI3pTysZRD5BLqK36LpFldwcDKJJuWojioyLC1s+aCGseYVDRnGGEi6uEm8pN9QNA44Tw4ouA8BgnJDdifISaBlJ1cNo3ONLFCHvFc7+EaSGhpkYfjPORIdQJEUgyfROmxYSa6rZtqu4mCBdPC381woc44cKdfgnTCSG0yXNOJCGREaUJ08NCOL7Qpw0TQ2iFERIZUZYwnSxCQaRxMiLaaxSIs9y8893pxBCWQwkXrq2gWr3GUZEN6BBy2ie9hEh72CUL6wV85vTTElM/3VlkAjrt0ymzCdaV8WFNE1RtL8StQ5EzASgghGlC71mIugjD6tJ+CEnAdJ5lRm1NPugtgvPbZ6qEFKDLeCdH7kZt3dM+OWrrCAHDCVmALDNqIwTjUuRWSvGcKYyQDegyvi9gZtR2cqZKnZc5UCHkArpmXF05DaRtErVpkwmRShcRCAWALiOqE12E8JK94Mhhn4QLIXwE7aEuwpRNDmrW830SRgFM5/WdI61RF2IIQw2fMB+JsKgNEI6EkVDTTacjE+ZaEQm7+gg3qcr0zF1rJEI3vUUjzGu8kbbubUT0qr1ibxHShF4Cj0ao0Unh1BvN+V2wDBbhwu0CjReZMK/RSf2NuBUc6QRLoQnROT9ahEUj1Hq3N7xXBrlU4QBbDoH45RKF5xK+D5J5OOGBTsBUBeQLxE2PWYuEiIurzKsPTu/6CjehvnTf0xblpiDWcPSWM5YAWnoUSqg1zqT80hQpa1IvRJ6WZ/bsUIX3oV6aP9ZMCO47RJN+SrzCVbYVe4B3w7ehbhPCaIpdYMrcib445+ZdVz0N5dO+C1P+9RjYE4UOhGvk++nbcEK9gdSTN8rAbno6Exoxf8oxYXiUSefPDBBuMox4IlzmW+bVXBJRRnM548tLidjV+uvihbIIZaKMgTDTE7iYHTPioXC5DMLWigSgER9N+XUNFk5TXdGCWTaUiDKGfDQV3PmEPfhKFE9pQpkoYySOAgEbYjd3ibYiRSgTZdJFg7dzg3uf8Ae0CVIGSdi6LbMJjT4ii74dPyWKNgRh61QG8Jdt3l/XoW3m7ercEpwgXJaJMr+STy3SLFCdWk3sKA8RJ2w9kkj1/5mfRhCbjOdsDVjwVCLxIEEO4lILkVQt8+s88kifVMO22xXGKgYq/9Ef+HP2jtkLxhTKl07/Mu8/7ybl1YlWlv1AvwEKPr4li++WM4n1h+rMf6SPa8Uy+C4bms3oVzY1/A93itHm2ZTyxQ72ZE3/D2V1OyqMp9Y+8cKJEiI4kxY8tWgf/h39oRU+tpR6Mit7M0oK9vQQERrQ1h9Og62IPz/C0fpBn2bMPwwqNQ8RAmIPONCnfR5i6jDdB2M+jQ1l3L3oA5JbQZMqJYvjqO75jIiM+fQL4iPuzUPAbEl7OgSq+98xnZHXIzHm012qlfA/ncy6OlWGWdEq0U+glWfMF1/QrVK95BNOG6xR/Rocu3XW1+FBOGQ+/ZA1FA0+OUs8WVOztgNXYj7sev1YCOngHTM73aqNAk6btGI5QNxix4PO4YlDSWE6Rw66Z+xGvrLlA1r4kzVNqJ71NyO/PF7vvOieFNN+8X3Q7R53uGOKveAja/iTNc2o0kSeCB1DWK/sBgZsVrAnaxoTsqSs8r9IWMsiX5h7wLeiuZyBxQW7qTRg2W4iHwVqUQ/RKKAbUoPgbrf7dqdyO/gYK+t/VW4BZxgQi35Zy273ZcftdvAZeGS+Nz9vdPTmac1Cvn+7GXU/VjabNmpAvFu6Z9qCPdVRE2TtWiOCs5YbNezNWwn9hyebyG50DVmrSkGWqzUbe6P+sZO8qhijC9nYrItyZH2zgeM5HxD2v07Mqt6wsPU6kHZpq7pXpjAr5b3qVsmyiV+3Ggl10ED1BrFod9nOodp+e7daXXNUre6292sOu0X9op18PleVKhY2UFIo9su1qqlePrIqm20OBVeW1R6y/4lVru5T3srHs0vVoXBPQvVqieeQGJ21L5dVEqnKXqOZpSOK75l2ttnYG5rNx1O9vNZol7K2TXptqbG2PfR0gSr17b3N5zMz1kxPbjv0hek1DUBf+KfNRoTDqhHh8GtEOPwaEQ6/RoTDpu1qe7+EqYbV3dmvcJV2h6pDrFQZUwqquZghtTs0bSI+WIzCmOxJm6+GLcXnikIciv8NvRVlSEMhlsL/gGlFsCATsRn+J8wKXnzaN+K0iYvYoqgWzhRixJlkDzfgRYsqiMkOqM3IgDThV6YhRKpHHHa7orNikgeo4AZFRSMm2U2rfdiQJjRzxayrypUrIXGuYX2Oyl3/5xwF56KofMH6Z/SD0IXLhH57PDn5+DfyKKb/XkW18djRg6tM/fH73/i6IquLKoCV2TlcO5M97cwJNIZq6knvDRtTY7TmLl/5LAYpmfAWvtyxqQce4X3Getl66r3hAZPwUhyASrXBzVliTcCE8oTAhEzCuQ9xAF6J1YRj9wHhVVnCDdFXMhEHoZIJLz7jWOQJy+dYgl49yXht7lYcgGom/Mhz0g1JwLEx8IYjlpOej4NQKZCmqEVBJ5U14dhV8IYd1otxAMbtpA/4FmHrPt+r43FStVRxgXTSqahOKvpK4omkXysRfiQj6Y7I55h6wv9KZp1teElVituQyhVgVz2RBhwTfCWzn02cV5faKOATSbjRLyHrpdlLMQCen1AjJBcFCaUDjZAwDhMqGpFaVN+ErDfMxgJ4Tmkjcm0oDajBhiqAqcsDjjRxAKpliw+xZQtWoT57ST2YTkyonaiiMj40iXRnMSZoJ+fOxZHx1fIh1R3C1kK+Ozzy3pDU7jBF1aVHUYMpbA9Zr32Kg1CtLqVDDVyw9EYUtlvmG2D+RpRvLkRDjI9xEKoFUyrni1p2tkRjjyS4KdXkQzd9KksI3ZRlxNkERFO6cANedyRLCK3OdNMkGJHaiU8FkYOpHcFXEo8RFXfi5WezmDwjohbZEQdWkGEw6MCKcRAqhtPKTUwXbkxtOJoK5Hrh0ymR3DfMBT8e9WIx0KdbmD701+l/jUvNpDeI5XvbbGNKWl5wvQ9+uoHr3EQMUgo9F54R670K44i0QGxlvXTjw6UYANXqOGpRD2AZJ6v7AsKpGPgmJpR25YVZYkkw2x0xF8zSJP8riceEarvwE7kLoUV2ZAHhDJy5cc/HAKhmwpvkLgxOncnqSGDCW3GY8JKSCckabmrMt4hk+odfCXMGbj6Q8psp6U5DOAaJA1DNSVNUyy/o4NkSDes+mXdSeqgR+aS+cKhhPhnSp6IEkzSm/FNRjNfmPk6cP6cstVzBPdkmPdOAhKzucu6DOp8jJUKqHYaEsoC+0Vm9V0yESkYcMOHHvzxhPDZUaywGvA9jCDTn1E7UcGOp/Gn9owHHUsUTNTd5l2bI58P7g86HahmfqmlECZytgdc0aie9+XWpLKBflzJrBPPNE3/IL78RBb3FbCy9hdpGvEgRRr6Q74hv9bkE9Ie0m0a+GBP2+OyLMeOQmptyL6iVjjXQTVktZRK6C8qI/qxNEtA/K8AMTnMxACobkUyJO1HzhegKm0TsxI/EaYwbnhH/mJUWmHkzX3uWgFFN6gKp/z2e/PM8dVSg3/+c/PN33osX45AaIUORHT/ZtxaONNJII4000kjDq/8Dzwt64daPLKsAAAAASUVORK5CYII=",
                "History",
                randomColor()
            )
        )
        data.add(
            LessonModel(
                "data:image/png;base64,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",
                "Biology",
                randomColor()
            )
        )
        data.add(
            LessonModel(
                "https://yandex.ru/images/search?pos=0&from=tabbar&img_url=https%3A%2F%2Fsun3-11.userapi.com%2FJFgfvfHXbGZ9LzQD5J1iROpgsuHyre3IG-oFdw%2FCGliPn1bSW8.jpg&text=Чистописание&rpt=simage&lr=10309",
                "Calligraphy",
                randomColor()
            )
        )
        data.add(
            LessonModel("https://avatars.mds.yandex.net/i?id=c6a0bd51b0a93ca0691622026ce25b2d-4865933-images-thumbs&n=13",
                "Reading",
                randomColor())
        )
        data.add(
            LessonModel("https://avatars.mds.yandex.net/i?id=f69b8338bf0f255a369378b5d707aeb7-5448159-images-thumbs&n=13",
                "Labour",
                randomColor())
        )
        data.add(
            LessonModel("https://avatars.mds.yandex.net/i?id=961790e764c400999d20025f1de46bb7-4374572-images-thumbs&n=13",
                "Natural study",
                randomColor())
        )
        data.add(
            LessonModel("https://yandex.ru/images/search?text=математика+учебник&pos=0&rpt=simage&img_url=https%3A%2F%2Favatars.mds.yandex.net%2Fget-mpic%2F4380539%2Fimg_id8985368073919011050.jpeg%2Forig&from=tabbar&lr=10309",
                "Math",
                randomColor())
        )
        data.add(
            LessonModel("https://avatars.mds.yandex.net/i?id=4431cb186d523daf149050ed3a83c420-4146491-images-thumbs&n=13",
                "Music",
                randomColor())
        )
        data.add(
            LessonModel("https://yandex.ru/images/search?pos=0&from=tabbar&img_url=https%3A%2F%2Ffkniga.ru%2Fmedia%2Fproduct%2F07%2F07050302%2FKA-00146542.jpg&text=изо+учебник&rpt=simage&lr=10309",
                "Art",
                randomColor())
        )
        data.add(
            LessonModel("https://yandex.ru/images/search?pos=4&from=tabbar&img_url=https%3A%2F%2Fscontent-hel3-1.cdninstagram.com%2Fv%2Ft51.2885-15%2Fe35%2F26158820_309126942932072_5822388194808692736_n.jpg%3F_nc_ht%3Dscontent-hel3-1.cdninstagram.com%26_nc_cat%3D108%26_nc_ohc%3DTlGVEPY7zUMAX-J0DRy%26edm%3DABfd0MgBAAAA%26ccb%3D7-4%26oh%3D00_AT91slUsiLm6siFt0mU52zZuE82aA43K85KaQmsdsrx2Ag%26oe%3D61F23232%26_nc_sid%3D7bff83&text=Русский+язык&rpt=simage&lr=10309",
                "Russian language",
                randomColor())
        )
        data.add(
            LessonModel("https://yandex.ru/images/search?text=Иностранный+язык+учебник&pos=19&rpt=simage&img_url=https%3A%2F%2Fimage.isu.pub%2F130718095536-f4e34a302164144d280006804c3128eb%2Fjpg%2Fpage_1.jpg&from=tabbar&lr=10309",
                "English language",
                randomColor())
        )
        data.add(
            LessonModel("https://yandex.ru/images/search?pos=0&from=tabbar&img_url=https%3A%2F%2Ffantasticbook.ru%2Fpict%2F1022574140.jpg&text=литература+учебник&rpt=simage&lr=10309",
                "Literature",
                randomColor())
        )
        data.add(
            LessonModel("https://yandex.ru/images/search?pos=0&from=tabbar&img_url=https%3A%2F%2Ffkniga.ru%2Fmedia%2Fproduct%2F07%2F07050302%2FKA-00102986.jpg&text=ОБЖ+учебник&rpt=simage&lr=10309",
                "Life safety",
                randomColor())
        )
    }
}

