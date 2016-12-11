module.exports = (robot) ->
  robot.hear /generate some degradation/i, (msg) ->
    data = JSON.stringify({
        variables:
          country: "FRA"
          branchId: "233b38a4-f0bf-4289-bfdc-7f2a04fc4ab3"
          committed: true
          aaCompositeKey: "FRA.11.95.95306"
          lng: 2.1334867
          aa1Name: "11"
          editId: 3965317
          aa7Name: "95"
          version: 24585852
          userId: "am25260"
          transactionId: "1ce9b75d-7a8c-4f32-9aca-5c88bca054c2"
          aa9Name: "N/A"
          causingProject: "WEU_FRA_ACIMSR"
          aa2Name: "N/A"
          containerName: "8"
          ruleInfo: "Suspicious loss of Speed Restrictions Verification Flag"
          ruleID: 51775
          featureId: "bf9575c8-021c-42b1-afef-37e26f039295, 00004632-3000-0400-0000-000004019131, 00004632-3000-0400-0000-000004019130, 00004632-3000-0400-0000-00000400afd4"
          lat: 49.0032017
          aa8Name: "95306"
          toolName: "Samantha :-D"
      })
    msg.http("http://flux.cd.cpp-dev-qap.amiefarm.com/api/engine/process-instances/degradation_solving_process")
       .headers({ "Content-Type": "application/json", "Accept": "application/hal+json" })
       .post(data) (err, res, body) ->
          msg.send 'There you go, you should see some degradation at http://flux.cd.cpp-dev-qap.amiefarm.com'
