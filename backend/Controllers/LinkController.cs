using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;

namespace backend.Controllers;

[ApiController]
[Route("[controller]")]
[EnableCors("mypolicy")]

public class LinkController : ControllerBase
{
    private readonly ILogger<LinkController> _logger;

    public LinkController(ILogger<LinkController> logger)
    {
        _logger = logger;
    }
    
    [HttpPost(Name = "GetToken")]
    public async Task Post([FromQuery(Name = "code")] string code)
    {
        await SpotifyAPI.Initiate(code);
        SpotifyAPI.CreateInstance();
    }
}