/*   Copyright (C) 2013-2014 Computer Sciences Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */

package ezbake.protect.mock.server;

import ezbake.base.thrift.EzBakeBaseThriftService;
import ezbake.ezca.EzCA;
import ezbake.base.thrift.EzSecurityToken;
import org.apache.thrift.TException;
import org.apache.thrift.TProcessor;


public class EzCAMockService extends EzBakeBaseThriftService implements EzCA.Iface {

	private static final String cert = "-----BEGIN CERTIFICATE-----\n" +
            "MIIC+jCCAeKgAwIBAwIBADANBgkqhkiG9w0BAQUFADBkMQswCQYDVQQGEwJVUzER\n" +
            "MA8GA1UECBMITWFyeWxhbmQxETAPBgNVBAcTCENvbHVtYmlhMQwwCgYDVQQKEwND\n" +
            "U0MxDjAMBgNVBAsTBTQyc2l4MREwDwYDVQQDEwhFemJha2VDQTAeFw0xMzEyMDIx\n" +
            "NjMzMDhaFw0xNDEyMDIxNjMzMDhaMB0xGzAZBgNVBAMMElNlY3VyaXR5Q2xpZW50\n" +
            "VGVzdDCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEBAMD47xhqpTvWz1dD\n" +
            "zi1HjlCfkQqETrWS7uAqx+Wah/i0h+wRKOE2wKzIlvcXPtGiFf5fpWlrL9Oriywa\n" +
            "jrawL0xCsgaBnSjQ9iuoL9p4ihSwdmusdB/wAVQBBMhokzl8N727jHi+Hcc4MmP6\n" +
            "K19sTcwLkJoJRNr3klRoTmTt+un4tlo87efA/LZQgN6+cVdLzJExLbrJbRCasW95\n" +
            "qEU+eQgx9eEeQ8QFFuHmN31pfN9Jhl7KSnF8TJpkTJNfBxCqZFL0Mk2Yfrq5mwSq\n" +
            "Wm/a4FN6TNEd9stSovIacYe+aPz9RjbYBjRCFDApBRMWTljnzswr1oAS2mkrHq73\n" +
            "Xkb6W9cCAwEAATANBgkqhkiG9w0BAQUFAAOCAQEAaGQg5THBIj1JC6hINg883Teb\n" +
            "csLqxVhsldQEurpNy4uN0L4xkkd5j5YHn11+DvV0WGwU72He/Wlz6rD0TF8naNes\n" +
            "79QmXh7LKOaiFG5D6t/zNIoL8YLqAy9C9mHb390pZC81FjQ9gGAI1vme8QJrGYUa\n" +
            "WtvoPffTc1ljp/I90jeVH7nZY+BMdQk6i+E/NSNq+OLRRvpPodofycZJqSAr4LLq\n" +
            "xtpq3/oOGqqNKT3k8jbN/HklpemLhXnTEe/DdYWw+6yW9NNLvzCM8T4oJEd+cztV\n" +
            "wlUeeCXc8G8N3F2NQQKFM6cEZVu7DJAOslzUe17D1SXZPSpP4N97PLr5bsHkZg==\n" +
            "-----END CERTIFICATE-----";
	
	@Override
	public String csr(EzSecurityToken token, String csr) throws TException {
		return cert;
	}

    @Override
    public TProcessor getThriftProcessor() {
        EzCA.Processor p = new EzCA.Processor(this);
        return p;
    }

}
