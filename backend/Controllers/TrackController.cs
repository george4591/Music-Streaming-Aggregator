using Microsoft.AspNetCore.Mvc;
using SpotifyAPI.Web;

namespace backend.Controllers;

[ApiController]
[Route("[controller]")]
public class TrackController : ControllerBase
{
    private readonly SpotifyClient _client;

    private readonly ILogger<TrackController> _logger;

    public TrackController(ILogger<TrackController> logger)
    {
        _logger = logger;
        _client = SpotifyAPI.GetInstance();
    }

    [HttpGet(Name = "GetTrack")]
    [ProducesResponseType(typeof(Track), StatusCodes.Status200OK)]
    public async Task<OkObjectResult> Get([FromQuery(Name = "id")] string id)
    {
        var user = await _client.UserProfile.Current();
        var track = await _client.Tracks.Get(id);
        
        return Ok(new Track
        {
            name = track.Name,
            id = track.Id,
            href = track.Href
        });
    }
}