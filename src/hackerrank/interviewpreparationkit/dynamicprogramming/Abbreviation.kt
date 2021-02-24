package hackerrank.interviewpreparationkit.dynamicprogramming

/**
 * https://www.hackerrank.com/challenges/abbr/problem
 * */
fun main() {
    //println(abbreviation.abbreviation("", "")) //

    val abbreviation = Abbreviation()
    println("${abbreviation.abbreviation("AbcDE", "ABDE")}, YES") //YES
    println("${abbreviation.abbreviation("AbcDE", "AFDE")}, NO") //NO
    println("${abbreviation.abbreviation("daBcd", "ABC")}, YES") //YES
    println("${abbreviation.abbreviation("AbCdE", "AFE")}, NO") //NO
    println("${abbreviation.abbreviation("beFgH", "EFG")}, NO") //NO
    println("${abbreviation.abbreviation("beFgH", "EFH")}, YES") //YES

    println("")

    println("${abbreviation.abbreviation("XXVVnDEFYgYeMXzWINQYHAQKKOZEYgSRCzLZAmUYGUGILjMDET", "XXVVDEFYYMXWINQYHAQKKOZEYSRCLZAUYGUGILMDETQVWU")}, NO") //NO
    println("${abbreviation.abbreviation("PVJSNVBDXABZYYGIGFYDICWTFUEJMDXADhqcbzva", "PVJSNVBDXABZYYGIGFYDICWTFUEJMDXAD")}, YES") //YES
    println("${abbreviation.abbreviation("QOTLYiFECLAGIEWRQMWPSMWIOQSEBEOAuhuvo", "QOTLYFECLAGIEWRQMWPSMWIOQSEBEOA")}, YES") //YES
    println("${abbreviation.abbreviation("DRFNLZZVHLPZWIupjwdmqafmgkg", "DRFNLZZVHLPZWI")}, YES") //YES
    println("${abbreviation.abbreviation("SLIHGCUOXOPQYUNEPSYVDaEZKNEYZJUHFXUIL", "SLIHCUOXOPQYNPSYVDEZKEZJUHFXUIHMGFP")}, NO") //NO
    println("${abbreviation.abbreviation("RYASPJNZEFHEORROXWZFOVDWQCFGRZLWWXJVMTLGGnscruaa", "RYASPJNZEFHEORROXWZFOVDWQCFGRZLWWXJVMTLGG")}, YES") //YES
    println("${abbreviation.abbreviation("AVECtLVOXKPHIViTZViLKZCZAXZUZRYZDSTIHuCKNykdduywb", "AVECLVOXKPHIVTZVLKZCZAXZUZRYZDSTIHCKN")}, YES") //YES
    println("${abbreviation.abbreviation("wZPRSZwGIMUAKONSVAUBUgSVPBWRSTJZECxMTQXXA", "ZPRSZGIMUAKONSVAUBUSVPBWRSTJZECMTQXXA")}, YES") //YES
    println("${abbreviation.abbreviation("SYIHDDSMREKXOKRFDQAOZJQXRIDWXPYINFZCEFYyxu", "SYIHDDSMREKXOKRFDQAOZJQXRIDWXPYINFZCEFY")}, YES") //YES
    println("${abbreviation.abbreviation("EIZGAWWDCSJBBZPBYVNKRDEWVZnSSWZIw", "EIZGAWWDCSJBBZPBYVNKRDEWVZSSWZI")}, YES") //YES

    println("")

    println("${abbreviation.abbreviation("RDWPJPAMKGRIWAPBZSYWALDBLDOFLWIQPMPLEMCJXKAENTLVYMSJNRJAQQPWAGVcGOHEWQYZDJRAXZOYDMNZJVUSJGKKKSYNCSFWKVNHOGVYULALKEBUNZHERDDOFCYWBUCJGbvqlddfazmmohcewjg", "RDPJPAMKGRIWAPBZSYWALDBLOFWIQPMPLEMCJXKAENTLVYMJNRJAQQPWAGVGOHEWQYZDJRAXZOYDMNZJVUSJGKKKSYNCSFWKVNHOGVYULALKEBUNZHERDOFCYWBUCJG")}, NO") //NO
    println("${abbreviation.abbreviation("MBQEVZPBjcbswirgrmkkfvfvcpiukuxlnxkkenqp", "MBQEVZP")}, NO") //NO
    println("${abbreviation.abbreviation("DINVMKSOfsVQByBnCWNKPRFRKMhFRSkNQRBVNTIKNBXRSXdADOSeNDcLWFCERZOLQjEZCEPKXPCYKCVKALNxBADQBFDQUpdqunpelxauyyrwtjpkwoxlrrqbjtxlkvkcajhpqhqeitafcsjxwtttzyhzvh", "DINVMKSOVQBBCWNKPRFRKMFRSNQRBVNTIKNBXRSXADOSNDLWFCERZOLQEZCEPKXPCYKCVKALNBADQBFDQU")}, YES") //YES
    println("${abbreviation.abbreviation("BFZZVHdQYHQEMNEFFRFJTQmNWHFVXRXlGTFNBqWQmyOWYWSTDSTMJRYHjBNTEWADLgHVgGIRGKFQSeCXNFNaIFAXOiQORUDROaNoJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMvSTGEQCYAJSFvbqivjuqvuzafvwwifnrlcxgbjmigkms", "BFZZVHQYHQEMNEFFRFJTQNWHFVXRXGTFNBWQOWYWSTDSTMJRYHBNTEWADLHVGIRGKFQSCXNFNIFAXOQORUDRONJPXWZXIAABZKSZYFTDDTRGZXVZZNWNRHMSTGEQCYAJSF")}, YES") //YES
    println("${abbreviation.abbreviation("AQIUQVIPJDKYNEBPXFGVHCMFGvURORPRSTYQYJZCYJDNFRPRYTMZIsNDOJAOAGAEFRCDKUJBhdkedalbwoxxnoyowoxpdlelovibyiwat", "AQIUQVIPJDKYNEBPXFGVHCMFGURORPRSTYQYJZCYJDNFRPRYTMZINDOJAOAGAEFRCDKUJB")}, YES") //YES
    println("${abbreviation.abbreviation("HCPXJZTDXLWHYKHPPDFYFDJWTAETQLJCIIPVHMZHHOQTKONUHGYVKLXTFTBEMYAWXTCSwNJYALIGMIBDOWKIVStFATDOZCYSUCaATUWORPMTFPKTNHDSFWKRKBrXNBYICOZYDWLLElKKWTFAUSTZKFDCBQNYVcWKDHDMXJGFORwURHISYLBIZSOJXVRVBNPQLRJKIN", "HCPXJZTDXLWHYKHPPDFYFDJWTAETQLJCIIPVHMZHHOQTKONUHGYVKLXTFTBEMYAWXTCSNJYALIGMIBDOWKIVSFATDOZCYSUCATUWORPMTFPKTNHDSFWKRKBXNBYICOZYDWLLEKKWTFAUSTZKFDCBQNYVWKDHDMXJGFORURHISYLBIZSOJXVRVBNPQLRJKINIIOYB")}, NO") //NO
    println("${abbreviation.abbreviation("IZLAKtDFAITDNWMVQPDShQQFGTRIXDLNBQPZRpuRJMLLPHBMOWrNagJDPPREZSYBHIWKDHLkjPSEUWIVQYUfPPJYKCbPEKCSKBRIAAJTMDPAOLNWSQESOTRQZOFTMTTGTDTrWLPENHXHLDWAFNDZMIFlogtcddtulusydquboxquwmgcji", "IZLAKDFAITDNWMVQPDSQQFGTRIXDLNBQPZRRJMLLPHBMOWNJDPPREZSYBHIWKDHLPSEUWIVQYUPPJYKCPEKCSKBRIAAJTMDPAOLNWSQESOTRQZOFTMTTGTDTWLPENHXHLDWAFNDZMIF")}, YES") //YES
    println("${abbreviation.abbreviation("KRBPLVCTESRNPTCVNDMPTQYvFAWBGYPQHNXNAESRQMKFDZIEKVNZXSXKCFHQYCMMANPQFHWCEeNGOLWTUXZVMQNDZfRPLUFZcSTRLRYAZUKAZYXCVTNTNScSDFTBJSUKEQKZRDITZUCFVAPLCLTUWAXOnNHPYEOZDGWZPBJQBZEOFAeXTFJDWRHI", "KRBPVCTESRNPTCVNDMPTQYFWBGYPQHXNAESRQMFDZIEKVNZXSXKFHQYCMMANPQFHWCNGOLWTUXZVMQNDZRPLUFZSTRLRYAZUAZYXCVTNTNSSDTBJSUKEQKZRDITZUCFVAPCLTUWAXONHPYEOZDGWZPBJQBZEOAXTFJDWRHIPGQVCWODYNNV")}, NO") //NO
    println("${abbreviation.abbreviation("WOAECAAVWMSQMIMYMAPEVARGIZCTIVNLAgydhmrxwcjltpjdewxhxrtynyyuyhqwbpkwuqtpwmyhemjxvwoazumyfstoumreirdkwbmepwbrgmyhjgtqeltzxnwhbunvuoejnhfqcikggaqjgsoqhzrmu", "WOAECAAVWMSQMIMYMAPEVARGIZCTIVNLA")}, YES") //YES
    println("${abbreviation.abbreviation("RMPRWOBYTSjXGVJQPDQEHTWXMOGcHVWKATSWLBWPJBQTYKVHKMFKCYVVJXGLUEZTLSXChGBCAOAMiFEAPPAGWeMXXQAQTFCZGXKOGZLLUWTZDOYVWHIJZEIDOSHPwFWHYXCIZKTjKKVKQNDXMTCCBQMAGVCDPZOXHPSEQYthuqclzletakrqbzmaohadpog", "RMPRWOBYTSXGVJQPDQEHTWXMOGHVWKATSWLBWPJBQTYKVHKMFKCYVVJXGLUEZTLSXCGBCAOAMFEAPPAGWMXXQAQTFCZGXKOGZLLUWTZDOYVWHIJZEIDOSHPFWHYXCIZKTKKVKQNDXMTCCBQMAGVCDPZOXHPSEQY")}, YES") //YES
}

class Abbreviation {
    fun abbreviation(a: String, b: String): String {
        val n = a.length
        val m = b.length
        val dp: Array<Array<Int>> = Array(n + 1) { Array(m + 1) { 0 } }
        dp[0][0] = 1
        for (i in 0 until n) {
            for (j in 0..m) {
               if (dp[i][j] == 0) {
                   continue
               }
               if (j < m && a[i].toUpperCase() == b[j]) {
                   dp[i + 1][j + 1] = 1
               }
                if (!a[i].isUpperCase()) {
                    dp[i + 1][j] = 1
                }
            }
        }
        return if (dp[n][m] == 1) "YES" else "NO"
    }
}